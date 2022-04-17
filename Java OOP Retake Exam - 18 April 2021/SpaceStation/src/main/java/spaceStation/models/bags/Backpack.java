package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Backpack implements Bag{
    private List<String> item;
    public Backpack(){
        this.item = new ArrayList<>();
    }
    @Override
    public Collection<String> getItems() {
        return this.item;
    }
}
