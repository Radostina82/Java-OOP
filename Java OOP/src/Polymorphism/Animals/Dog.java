package Polymorphism.Animals;

public class Dog extends Animal {
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        //I am Oscar and my favourite food is Whiskas
        //MEEOW

        return super.explainSelf() + System.lineSeparator() + "DJAAF";
    }
}
