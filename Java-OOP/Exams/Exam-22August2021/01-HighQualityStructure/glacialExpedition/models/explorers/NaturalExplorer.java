package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Suitcase;

public class NaturalExplorer extends BaseExplorer{
    private static final double ENERGY_NEEDED = 7;
    private static final double ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
        setEnergyNeeded(ENERGY_NEEDED);
    }
}
