package Encapsulation.FootballTeamGenerator5;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, Team> teamList = new LinkedHashMap<>();

        while (!input.equals("END")) {
            String command = input.split(";")[0];
            String teamName = input.split(";")[1];
            try {
                if (command.equals("Team")) {
                    teamList.putIfAbsent(teamName, new Team(input.split(";")[1]));
                } else if (command.equals("Add")) {

                    if (!teamList.containsKey(teamName)) {
                        throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                    } else {
                        String playerName = input.split(";")[2];
                        int endurance = Integer.parseInt(input.split(";")[3]);
                        int sprint = Integer.parseInt(input.split(";")[4]);
                        int dribble = Integer.parseInt(input.split(";")[5]);
                        int passing = Integer.parseInt(input.split(";")[6]);
                        int shooting = Integer.parseInt(input.split(";")[7]);

                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teamList.get(teamName).addPlayer(player);
                    }

                } else if (command.equals("Remove")) {
                    String playerName = input.split(";")[2];
                    teamList.get(teamName).removePlayer(playerName);

                } else if (command.equals("Rating")) {
                    if (!teamList.containsKey(teamName)) {
                        throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                    }  else {
                        System.out.printf("%s - %d%n", teamName, (int)teamList.get(teamName).getRating());

                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            input = scanner.nextLine();
        }
    }
}
