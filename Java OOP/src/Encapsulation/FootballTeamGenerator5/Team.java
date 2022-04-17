package Encapsulation.FootballTeamGenerator5;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
   /* int index = -1;
        for (int i = 0; i < this.players.size(); i++) {
            if (name.equals(this.players.get(i).getName())){
                index = i;
                break;
            }
        }
        if (index == -1){
            throw  new IllegalArgumentException("Player " + name + " is not in " + this.name + " team.");
        }
        this.players.remove(index);*/
        boolean isRemove = true;
        List<Player> playerList = this.players;
        for (Player player : playerList) {
            if (player.getName().equals(name)){
                this.players.remove(player);
                isRemove = false;
                break;
            }
        }
        if (isRemove){
            throw new IllegalArgumentException("Player " + name + " is not in " + this.name + " team.");
        }
    }

    public double getRating() {

        return  Math.round(this.players.stream().mapToDouble(p-> p.overallSkillLevel()).average().orElse(0));
    }
}
