package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Map<String, Player> players;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        players.put(name, new CivilPlayer(name));

        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        } else {
            return ConstantMessages.GUN_TYPE_INVALID;
        }
        this.guns.offer(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = guns.poll();
        if (gun == null) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }
        if (!players.containsKey(name)) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
            players.get(name).getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), players.get(name).getName());
    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, players.values());
        if (mainPlayer.getLifePoints() == 100 && players.values().stream().allMatch(p->
                p.getLifePoints() == 50)){
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        }
        List<Player> deadPlayers = players.values().stream().filter(p-> !p.isAlive()).collect(Collectors.toList());

        StringBuilder out = new StringBuilder(ConstantMessages.FIGHT_HAPPENED);
        out.append(System.lineSeparator())
                .append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE,players.size()- deadPlayers.size()));

        for (Player player : deadPlayers) {
            players.remove(player.getName());
        }

        return out.toString().trim();
    }
}
