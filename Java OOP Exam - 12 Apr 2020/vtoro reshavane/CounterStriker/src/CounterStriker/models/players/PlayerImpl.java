package CounterStriker.models.players;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String userName, int health, int armor, Gun gun) {
        this.setUsername(userName);
        this.setHealth(health);
        this.setArmor(armor);
        this.gun = gun;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setGun(Gun gun) {
        if (gun == null){
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {
        if (this.armor >= points){
           this.armor -= points;
        }else {
            int decreasePoint = points - this.armor;
            this.armor = 0;
            if (this.health > decreasePoint){
                this.health -= decreasePoint;
            }else {
                this.health = 0;
            }
        }
    }
    @Override
    public String toString(){
        //"{player type}: {player username}
        //--Health: {player health}
        //--Armor: {player armor}
        //--Gun: {player gun name}"

        return String.format("%s: %s%n" +
                "--Health: %d%n" +
                "--Armor:  %d%n" +
                "--Gun: %s", this.getClass().getSimpleName(), this.getUsername(), this.getHealth(), this.getArmor(), this.getGun().getName());
    }
}
