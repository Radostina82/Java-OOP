package MilitaryElite;

public class Spy extends Soldier{
    private String codeNumber;
    protected Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return null;
    }
}
