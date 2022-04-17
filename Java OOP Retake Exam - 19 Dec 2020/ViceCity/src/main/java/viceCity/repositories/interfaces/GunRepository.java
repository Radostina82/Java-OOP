package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.*;

public class GunRepository implements Repository<Gun> {
    private Map<String,Gun> guns;

    public GunRepository() {
        this.guns = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(guns.values());
    }

    @Override
    public void add(Gun model) {
       this.guns.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Gun model) {
        Gun remove = this.guns.remove(model.getName());
        return remove!=null;
    }

    @Override
    public Gun find(String name) {
        return this.guns.get(name);
    }
}
