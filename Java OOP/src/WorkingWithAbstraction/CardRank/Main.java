package WorkingWithAbstraction.CardRank;

import WorkingWithAbstraction.CardSuit.Card;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input + ":");
        Rank[] values = Rank.values();
        for (Rank value : values) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.toString());
        }
    }
}
