package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.drinks.interfaces.Tea;

import java.util.*;

public class DrinkRepositoryImpl implements DrinkRepository<Drink>{
    private Collection<Drink> models;
    public DrinkRepositoryImpl(){
        this.models = new ArrayList<>();
    }
    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {

        return this.models.stream().filter(d-> d.getName().equals(drinkName) && d.getBrand().equals(drinkBrand)).
                findFirst().orElse(null);
    }

    @Override
    public Collection<Drink> getAll() {
        return  Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Drink drink) {
        this.models.add(drink);
    }
}
