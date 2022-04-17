package MilitaryElite;

import MilitaryElite.Interface.PrivateImpl;

public class Private extends Soldier implements PrivateImpl {
    private double salary;
    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %.2f", super.getFirstName(), super.getLastName(), super.getId(), this.getSalary());
    }
}
