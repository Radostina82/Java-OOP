package MilitaryElite.Interface;

import java.util.Collection;

public interface EngineerImpl extends SpecialisedSoldierImpl {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}
