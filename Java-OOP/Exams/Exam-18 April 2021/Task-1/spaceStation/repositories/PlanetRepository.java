package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;

public class PlanetRepository implements Repository<Planet>{
    private Collection<Planet> planets;

    @Override
    public Collection<Planet> getModels() {
        return this.planets;
    }

    @Override
    public void add(Planet model) {
        planets.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        return this.planets.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.stream().filter(planet -> planet.getName().equals(name)).findFirst().orElse(null);
    }
}
