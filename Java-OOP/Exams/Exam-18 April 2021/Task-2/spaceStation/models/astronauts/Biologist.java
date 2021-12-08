package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static final double OXYGEN = 70;
    private static final double OXYGEN_NEEDS = 5;
    public Biologist(String name) {
        super(name, OXYGEN);
        super.setOxygenNeeded(OXYGEN_NEEDS);
    }
}
