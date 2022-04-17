package WorkingWithAbstraction.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] lightColor = scanner.nextLine().split("\\s+");
        int count = Integer.parseInt(scanner.nextLine());
        List<TrafficLight> lightsList = new ArrayList<>();
        for (String s : lightColor) {
            TrafficLight light = new TrafficLight(Light.valueOf(s));
            lightsList.add(light);
        }
        for (int i = 0; i < count; i++) {
            for (TrafficLight light : lightsList) {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }
    }
}
