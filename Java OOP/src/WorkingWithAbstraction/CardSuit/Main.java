package WorkingWithAbstraction.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input + ":");
        Card[] values = Card.values();
        for (Card value : values) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.toString());
        }
    }
}
