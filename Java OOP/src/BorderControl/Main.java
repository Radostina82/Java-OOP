package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Identifiable> identifiables = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            if (tokens.length == 2) {
           identifiables.add(new Robot(tokens[0], tokens[1]));
            } else if (tokens.length == 3) {
            identifiables.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(input)){
                System.out.println(identifiable.getId());
            }
        }
    }
}
