package WorkingWithAbstraction.GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        Bags bags = new Bags(capacity);
        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i += 2) {
            String item = input[i];
            long weight = Long.parseLong(input[i + 1]);

            if (item.length() == 3) {
                bags.addCash(item, weight);
            } else if (item.toLowerCase().endsWith("gem") && item.length() > 3) {
                bags.addGems(item, weight);
            } else if (item.equalsIgnoreCase("gold")) {
                bags.addGold(weight);
            }
        }
        System.out.println(bags.toString());
    }
}
