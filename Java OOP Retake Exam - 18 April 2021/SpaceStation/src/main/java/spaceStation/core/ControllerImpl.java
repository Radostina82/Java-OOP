package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
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

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int countExploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;

        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        this.astronautRepository.add(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(Arrays.asList(items));
        this.planetRepository.add(planet);

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        } else {
            astronautRepository.remove(astronaut);
            return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
        }
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> astronautList = astronautRepository.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if (astronautList.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        } else {
            int countBeforeMission = astronautList.size();
            Mission mission = new MissionImpl();
            Planet planet = planetRepository.findByName(planetName);
            mission.explore(planet, astronautList);
            int countAfterMission = astronautList.size();
            this.countExploredPlanets++;
            return String.format(ConstantMessages.PLANET_EXPLORED, planetName, countBeforeMission - countAfterMission);
        }
    }

    @Override
    public String report() {
        //"{exploredPlanetsCount} planets were explored!"
        //"Astronauts info:"
        //"Name: {astronautName One}"
        //"Oxygen: {astronautOxygen One}"
        //"Bag items: {bagItem1, bagItem2, bagItem3, …, bagItemn \ "none"}"
        //…
        //"Name: {astronautName N}"
        //"Oxygen: {astronautOxygen N}"
        //"Bag items: {bagItem1, bagItem2, bagItem3, …, bagItemn \ "none"}"
        StringBuilder out = new StringBuilder();
        out.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, this.countExploredPlanets))
                .append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());
        this.astronautRepository.getModels().forEach(a -> {
            out.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, a.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, a.getOxygen()))
                    .append(System.lineSeparator());
            if (a.getBag().getItems().size()==0){
                out.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());
            }else {
                Collection<String> items = a.getBag().getItems();
                out.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,
                        String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, items)))
                .append(System.lineSeparator());
            }

        });


        return out.toString().trim();
    }
}
