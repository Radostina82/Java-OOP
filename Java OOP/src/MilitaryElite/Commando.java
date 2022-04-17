package MilitaryElite;

import MilitaryElite.Interface.CommandoImpl;
import MilitaryElite.Interface.Mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Commando extends SpecialisedSoldier implements CommandoImpl {
    private List<Mission> missions;
    public Commando(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }
}
