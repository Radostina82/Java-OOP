package CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field {

    public FieldImpl() {

    }

    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorist = players.stream().filter(p -> p.getClass().getSimpleName().equals("Terrorist")).filter(p -> p.isAlive()).collect(Collectors.toList());
        List<Player> counterTerrorist = players.stream().filter(p -> p.getClass().getSimpleName().equals("CounterTerrorist")).filter(Player::isAlive).collect(Collectors.toList());
        while (terrorist.stream().anyMatch(Player::isAlive) && counterTerrorist.stream().anyMatch(Player::isAlive)) {
            for (Player player : terrorist) {
                for (Player player1 : counterTerrorist) {
                    player1.takeDamage(player.getGun().fire());
                }
            }
            counterTerrorist = counterTerrorist.stream().filter(Player::isAlive).collect(Collectors.toList());
            for (Player player : counterTerrorist) {
                for (Player player1 : terrorist) {
                    player1.takeDamage(player.getGun().fire());
                }
            }
            terrorist = terrorist.stream().filter(Player::isAlive).collect(Collectors.toList());
        }
        return terrorist.stream().anyMatch(Player::isAlive) ? OutputMessages.TERRORIST_WINS : OutputMessages.COUNTER_TERRORIST_WINS;
    }
}
