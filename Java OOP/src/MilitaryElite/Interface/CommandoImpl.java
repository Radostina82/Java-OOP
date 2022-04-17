package MilitaryElite.Interface;

import java.util.Collection;

public interface CommandoImpl extends SpecialisedSoldierImpl {
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}
