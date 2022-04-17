package WorkingWithAbstraction.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowAndCol = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Galaxy galaxy = new Galaxy(rowAndCol[0], rowAndCol[1]);

        StarsManipulator starsManipulator = new StarsManipulator(galaxy);

        String input = scanner.nextLine();

        long sum = 0;
        while (!input.equalsIgnoreCase("Let the Force be with you")){

            int[] playerPositions = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] enemyPositions = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            starsManipulator.destroyStars(enemyPositions);

            sum += starsManipulator.sumOfStars(playerPositions);

            input = scanner.nextLine();
        }

        System.out.println(sum);
    }
}
