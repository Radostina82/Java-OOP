package MilitaryElite;


import MilitaryElite.Interface.LieutenantGeneralImpl;

import java.util.ArrayList;
import java.util.List;


public class LieutenantGeneral extends Private implements LieutenantGeneralImpl {
    private List<Private> privates;

    public LieutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        //"Name: <firstName> <lastName> Id: <id> Salary: <salary>
        //Privates:
        //  <private1 ToString()>
        //  <private2 ToString()>
        //  …
        //  <privateN ToString()>"


        return null;
    }

}
