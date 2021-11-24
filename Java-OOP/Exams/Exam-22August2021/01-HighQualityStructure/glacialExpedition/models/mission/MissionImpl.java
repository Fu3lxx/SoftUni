package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;


public class MissionImpl implements Mission{
    public MissionImpl() {
    }

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        ArrayDeque<String> states = new ArrayDeque<>(state.getExhibits());

        for (Explorer explorer:explorers){
            while (explorer.canSearch() && states.size() > 0){

                explorer.search();
                explorer.getSuitcase().getExhibits().add(states.pop());
            }
        }
    }
}
