package InterfacesAndAbstraction.Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Car car = new Ferrari(input);
        System.out.println(car);
    }
}
