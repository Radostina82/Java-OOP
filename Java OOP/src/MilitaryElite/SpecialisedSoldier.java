package MilitaryElite;

import MilitaryElite.Interface.SpecialisedSoldierImpl;

public abstract class SpecialisedSoldier extends Private implements SpecialisedSoldierImpl {
    private Corps corps;

    public SpecialisedSoldier(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }
}
