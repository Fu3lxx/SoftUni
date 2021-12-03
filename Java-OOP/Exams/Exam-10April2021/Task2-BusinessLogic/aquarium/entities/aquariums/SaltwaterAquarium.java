package aquarium.entities.aquariums;

import aquarium.entities.fish.Fish;

import static aquarium.common.ConstantMessages.*;

public class SaltwaterAquarium extends BaseAquarium{
    private static final int CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, CAPACITY);
    }
    @Override
    public void addFish(Fish fish) {
        if (CAPACITY > super.getFish().size()){
            if (fish.getClass().getSimpleName().contains("SaltwaterFish")){
                super.getFish().add(fish);
            }else {
                throw new IllegalArgumentException(WATER_NOT_SUITABLE);
            }
        }else {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
    }
}
