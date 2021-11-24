package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private Mission mission;
    private int exploredStates = 0;

    public ControllerImpl() {
        explorerRepository = new ExplorerRepository();
        stateRepository = new StateRepository();
        mission = new MissionImpl();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        if (type.equals("AnimalExplorer")){
            explorer = new AnimalExplorer(explorerName);
        }else if (type.equals("GlacierExplorer")){
            explorer = new GlacierExplorer(explorerName);
        }else if (type.equals("NaturalExplorer")){
            explorer = new NaturalExplorer(explorerName);
        }else {
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED,type,explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (var exhibit:exhibits){
            state.getExhibits().add(exhibit);
        }
        stateRepository.add(state);
        return String.format(STATE_ADDED,stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if (explorer == null){
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST,explorerName));
        }else {
            explorerRepository.remove(explorer);
            return String.format(EXPLORER_RETIRED,explorerName);
        }

    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> suitableExplorers = explorerRepository.getCollection().stream().filter(explorer -> explorer.getEnergy() > 50).collect(Collectors.toList());
        if (suitableExplorers.size() == 0){
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        State state = stateRepository.byName(stateName);
        mission.explore(state,suitableExplorers);
        long retired = suitableExplorers.stream().filter(explorer -> explorer.getEnergy() <= 0).count();
        exploredStates++;
        return String.format(STATE_EXPLORER,stateName,retired);
    }

    @Override
    public String finalResult() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(FINAL_STATE_EXPLORED,exploredStates)).append(System.lineSeparator());
        builder.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());

        for (var explorer:explorerRepository.getCollection()){
            builder.append(String.format(FINAL_EXPLORER_NAME,explorer.getName())).append(System.lineSeparator());
            builder.append(String.format(FINAL_EXPLORER_ENERGY,explorer.getEnergy())).append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().size() == 0){
                builder.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,"None")).append(System.lineSeparator());
            }else {
                builder.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,explorer.getSuitcase().getExhibits())))
                        .append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
}
