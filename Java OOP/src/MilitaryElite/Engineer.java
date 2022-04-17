package MilitaryElite;

import MilitaryElite.Interface.EngineerImpl;
import MilitaryElite.Interface.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements EngineerImpl {
    private List<Repair> repairs;
    public Engineer(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }
}
