package Encapsulation.FirstAndReserveTeam4;

import Encapsulation.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addPlayer(Person person){
        if (person.getAge()<40){
            this.firstTeam.add(person);
        }else {
            this.reserveTeam.add(person);
        }
    }
}
