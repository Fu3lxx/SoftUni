package aquarium.entities.aquariums;

import aquarium.entities.fish.Fish;

import static aquarium.common.ConstantMessages.*;

public class FreshwaterAquarium extends BaseAquarium{
    private static final int CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addFish(Fish fish) {
        if (CAPACITY > super.getFish().size()){
            if (fish.getClass().getSimpleName().contains("FreshwaterFish")){
                super.getFish().add(fish);
            }else {
                throw new IllegalArgumentException(WATER_NOT_SUITABLE);
            }
        }else {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
    }
}
