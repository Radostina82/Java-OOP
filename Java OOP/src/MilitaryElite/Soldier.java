package MilitaryElite;

import MilitaryElite.Interface.SoldierImpl;

public abstract class Soldier implements SoldierImpl {
    private int id;
    private String firstName;
    private String lastName;

    protected Soldier(int id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }
    @Override
    public abstract String toString();
}
