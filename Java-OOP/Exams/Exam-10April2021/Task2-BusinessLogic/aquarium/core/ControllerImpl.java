package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;


import java.util.ArrayList;

import java.util.List;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private DecorationRepository decorations;
    private List<Aquarium> aquariums;

    public ControllerImpl() {
        aquariums = new ArrayList<>();
        decorations = new DecorationRepository();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")){
            aquarium = new FreshwaterAquarium(aquariumName);
        }else if (aquariumType.equals("SaltwaterAquarium")){
            aquarium = new SaltwaterAquarium(aquariumName);
        }else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE,aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        if (type.equals("Ornament")){
            decoration = new Ornament();
        }else if (type.equals("Plant")){
            decoration = new Plant();
        }else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE,type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);
        if (decoration == null){
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND,decorationType));
        }
        Aquarium aquarium = aquariums.stream().filter(aq->aq.getName().equals(aquariumName)).findFirst().orElse(null);
        aquariums.get(aquariums.indexOf(aquarium)).addDecoration(decoration);
        decorations.remove(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM,decorationType,aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        if (fishType.equals("SaltwaterFish")){
            fish = new SaltwaterFish(fishName,fishSpecies,price);
        }else if (fishType.equals("FreshwaterFish")){
            fish = new FreshwaterFish(fishName,fishSpecies,price);
        }else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        Aquarium aquarium = aquariums.stream().filter(aq-> aq.getName().equals(aquariumName)).findFirst().orElse(null);
        aquariums.get(aquariums.indexOf(aquarium)).addFish(fish);

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,fishType,aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = aquariums.stream().filter(aq -> aq.getName().equals(aquariumName)).findFirst().orElse(null);
        return String.format(FISH_FED,aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums.stream().filter(aq-> aq.getName().equals(aquariumName)).findFirst().orElse(null);
        double value =
                aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum() +
                        aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format(VALUE_AQUARIUM,aquariumName,value);
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        for (var aquarium: aquariums){
            builder.append(aquarium.getInfo()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
