package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.*;

public class BeveragesRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> beverages;
    public BeveragesRepositoryImpl(){
        this.beverages = new ArrayList<>();
    }
    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {

        return this.beverages.stream()
                .filter(b-> b.getName().equals(drinkName) && b.getBrand().equals(drinkBrand))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(this.beverages);
    }

    @Override
    public void add(Beverages entity) {
        this.beverages.add(entity);
    }
}