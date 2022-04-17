package MilitaryElite;

import org.w3c.dom.html.HTMLMapElement;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;

public class Main {
    private static Map<Integer, Soldier> soldiersById = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            Soldier aPrivate;
            if (command.equals("Private")) {
                aPrivate = new Private(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));

            } else if (command.equals("LieutenantGeneral")) {
                aPrivate = createLieutenantGeneral(tokens);
            } else if (command.equals("Engineer")) {
                aPrivate =createEngineer(tokens);
            } else if (command.equals("Commando")) {
                aPrivate = new Commando(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), Corps.valueOf(tokens[5]));
            } else if (command.equals("Spy")) {
                aPrivate = new Spy(Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4]);
            }

            input = scanner.nextLine();
        }
    }

    private static Soldier createEngineer(String[] tokens) {
        //new Engineer(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), Corps.valueOf(tokens[5]));
return null;
    }

    private static Soldier createLieutenantGeneral(String[] tokens) {
        LieutenantGeneral lieutenantGeneral = new LieutenantGeneral(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));
        for (int i = 5; i < tokens.length; i++) {

        }
        return lieutenantGeneral;
    }
}
