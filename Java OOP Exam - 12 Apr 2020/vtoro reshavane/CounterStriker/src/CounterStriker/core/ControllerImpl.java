package CounterStriker.core;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.common.OutputMessages;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name, bulletsCount);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name, bulletsCount);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
        }

        this.guns.add(gun);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Player player;
        Gun gun = this.guns.findByName(gunName);
        if (gun == null) {
            throw new NullPointerException(ExceptionMessages.GUN_CANNOT_BE_FOUND);
        }

        if (type.equals("CounterTerrorist")) {
            player = new CounterTerrorist(username, health, armor, gun);
        } else if (type.equals("Terrorist")) {
            player = new Terrorist(username, health, armor, gun);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

        this.players.add(player);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        List<Player> playerList = this.players.getModels().stream().filter(Player::isAlive).collect(Collectors.toList());
       // this.field.start(this.players.getModels().stream().filter(Player::isAlive).collect(Collectors.toList()));
        return this.field.start(playerList);
    }

    @Override
    public String report() {
        StringBuilder out = new StringBuilder();

        this.players.getModels().stream().sorted((p1, p2) -> {
            int i = p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
            if (i == 0) {
                i = Integer.compare(p2.getHealth(), p1.getHealth());
            }
            if (i == 0) {
                i = p1.getUsername().compareTo(p2.getUsername());
            }
            return i;
        }).forEach(player -> out.append(player.toString()).append(System.lineSeparator()));

        return out.toString().trim();

    }
}
