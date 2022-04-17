package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public class Terrorist extends PlayerImpl{
    public Terrorist(String userName, int health, int armor, Gun gun) {
        super(userName, health, armor, gun);
    }
}
