package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private Mission mission;
    private int exploredPlanets = 0;
    public ControllerImpl() {
        astronautRepository = new AstronautRepository();
        planetRepository = new PlanetRepository();
        mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        if (type.equals("Biologist")){
            astronaut = new Biologist(astronautName);
        }else if (type.equals("Meteorologist")){
            astronaut = new Meteorologist(astronautName);
        }else if (type.equals("Geodesist")){
            astronaut = new Geodesist(astronautName);
        }else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED,type,astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item:items){
            planet.getItems().add(item);
        }
        planetRepository.add(planet);
        return String.format(PLANET_ADDED,planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (astronaut == null){
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST,astronautName));
        }
        astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED,astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> suitable = astronautRepository
                .getModels().stream()
                .filter(astronaut -> astronaut.getOxygen() > 60)
                .collect(Collectors.toList());
        if (suitable.size() == 0){
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet planet = planetRepository.findByName(planetName);
        mission.explore(planet,suitable);
        long dead = suitable.stream().filter(astronaut -> astronaut.getOxygen() <=0).count();
        exploredPlanets++;

        return String.format(PLANET_EXPLORED,planetName,dead);
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(REPORT_PLANET_EXPLORED,exploredPlanets)).append(System.lineSeparator());
        builder.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut astronaut:astronautRepository.getModels()){
            builder.append(String.format(REPORT_ASTRONAUT_NAME,astronaut.getName())).append(System.lineSeparator());
            builder.append(String.format(REPORT_ASTRONAUT_OXYGEN,astronaut.getOxygen())).append(System.lineSeparator());
            String items;
            if (astronaut.getBag().getItems().size() == 0){
                items = "none";
            }else {
                items = String.join(", ",astronaut.getBag().getItems());
            }
            builder.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,items)).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
