package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.Bread;
import bakery.entities.bakedFoods.interfaces.Cake;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.drinks.interfaces.Tea;
import bakery.entities.drinks.interfaces.Water;
import bakery.entities.tables.interfaces.InsideTable;
import bakery.entities.tables.interfaces.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.sql.SQLOutput;

public class ControllerImpl implements Controller {


    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {

        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.totalIncome = 0.0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood food = this.foodRepository.getByName(name);
        if (food != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, food.getClass().getSimpleName(), name));
        }

        if (type.equals("Bread")) {
            food = new Bread(name, price);
        } else if (type.equals("Cake")) {
            food = new Cake(name, price);

        }
        this.foodRepository.add(food);
        return String.format(OutputMessages.FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = this.drinkRepository.getByNameAndBrand(name, brand);
        if (drink != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, drink.getClass().getSimpleName(), name));
        }

        if (type.equals("Tea")) {
            drink = new Tea(name, portion, brand);

        } else if (type.equals("Water")) {
            drink = new Water(name, portion, brand);
        }
        this.drinkRepository.add(drink);
        return String.format(OutputMessages.DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {

        Table table1 = null;
        if (type.equals("InsideTable")) {
            table1 = new InsideTable(tableNumber, capacity);

        } else if (type.equals("OutsideTable")) {
            table1 = new OutsideTable(tableNumber, capacity);
        }
        Table table = this.tableRepository.getByNumber(tableNumber);
     /*   if (table != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
        }*/
        if (table1 == table) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
        }
        this.tableRepository.add(table);

        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {

       /* String output = "";
        Table table = this.tableRepository.getAll().stream().filter(t -> t.getCapacity() >= numberOfPeople && !t.isReserved())
                .findFirst().orElse(null);
        if (table == null) {
            output = String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            output = String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
        }*/
        for (Table table : this.tableRepository.getAll()) {
            if (!table.isReserved() && table.getCapacity() >= numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }

        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {

        Table table = this.tableRepository.getByNumber(tableNumber);
        BakedFood bakedFood = this.foodRepository.getByName(foodName);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        if (bakedFood == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, foodName);
        }
        table.orderFood(bakedFood);
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);

    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {

        Table table = this.tableRepository.getByNumber(tableNumber);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        Drink drink = this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        if (drink == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        table.orderDrink(drink);

        return String.format(OutputMessages.DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        this.totalIncome += bill;
        table.clear();
        return String.format(OutputMessages.BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder builder = new StringBuilder();
        for (Table t : this.tableRepository.getAll()) {
            if (!t.isReserved()) {
                builder.append(t.getFreeTableInfo()).append(System.lineSeparator());
            }
        }
        return builder.toString().trim();

    }

    @Override
    public String getTotalIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, this.totalIncome);
    }
}
