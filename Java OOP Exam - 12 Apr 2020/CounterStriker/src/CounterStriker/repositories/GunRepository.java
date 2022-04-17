package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class GunRepository implements Repository<Gun> {
    private List<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayList<>();
    }

    @Override
    public List<Gun> getModels() {

        return this.guns;
    }

    @Override
    public void add(Gun model) {
        this.guns.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return guns.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        return guns.stream().filter(g-> g.getName().equals(name)).findFirst().orElse(null);
    }
}
