package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.*;


public class FieldImpl implements Field{

    @Override
    public String start(List<Player> players) {
        List<Player> counterTerrorist = players.stream().filter(p->p instanceof CounterTerrorist).collect(Collectors.toList());
        List<Player> terrorist = players.stream().filter(p->p instanceof Terrorist).collect(Collectors.toList());

        while (counterTerrorist.stream().anyMatch(Player::isAlive) && terrorist.stream().anyMatch(Player::isAlive)){
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
        return terrorist.stream().anyMatch(Player::isAlive) ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;
    }
}
