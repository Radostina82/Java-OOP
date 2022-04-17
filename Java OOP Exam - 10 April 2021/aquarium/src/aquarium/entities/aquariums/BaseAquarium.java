package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.WATER_NOT_SUITABLE;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(d -> d.getComfort()).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() == this.capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
       String fishWaterType = fish.getClass().getSimpleName().replaceAll("Fish", "");

        if (!this.getClass().getSimpleName().contains(fishWaterType)) {
            throw new IllegalStateException(WATER_NOT_SUITABLE);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        //String fishOutput = fish.isEmpty()
        //                ? "none"
        //                : fish.stream().map(Fish::getName).collect(Collectors.joining(" "));
        String fishOut ="";
        if (this.fish.isEmpty()){
            return "none";
        }else {
             fishOut = this.fish.stream().map(f-> f.getName()).collect(Collectors.joining(" "));
        }
        //"{aquariumName} ({aquariumType}):
        //Fish: {fishName1} {fishName2} {fishName3} (…) / Fish: none
        //Decorations: {decorationsCount}
        //Comfort: {aquariumComfort}"
        return String.format("%s %s:%n" +
                "Fish: %s%n" +
                "Decorations: %d%n" +
                "Comfort: %d",this.name, this.getClass().getSimpleName(),fishOut, this.decorations.size(), calculateComfort() );
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
