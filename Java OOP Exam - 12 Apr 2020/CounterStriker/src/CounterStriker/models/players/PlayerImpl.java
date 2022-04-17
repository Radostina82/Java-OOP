package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String userName;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String userName, int health, int armor, Gun gun) {
        this.setUserName(userName);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
    }

    private void setUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.userName = userName;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }


    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
        if (this.armor > points) {
            this.armor -= points;
        } else {
            int newPoint = points - this.armor;
            this.armor = 0;
            if (this.health > newPoint) {
                this.health -= newPoint;
            }else {
                this.health = 0;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n" +
                "--Health: %d%n" +
                "--Armor: %d%n" +
                "--Gun: %s", getClass().getSimpleName(), this.userName, this.health, this.armor, this.gun.getName());
    }
}
