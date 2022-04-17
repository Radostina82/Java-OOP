package Polymorphism.Vehicles;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tokens = scanner.nextLine().split("\\s+");
        LinkedHashMap<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        Vehicle car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
        vehicleMap.put(tokens[0], car);
        tokens = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
        vehicleMap.put(tokens[0], truck);
        tokens = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
        vehicleMap.put(tokens[0], bus);
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String type = tokens[1];
            double argument = Double.parseDouble(tokens[2]);

            if (command.equals("Drive") && type.equals("Bus")){
                System.out.println(bus.driveWithPassenger(argument));
            }else if (command.equals("Refuel")){
                try {
                    vehicleMap.get(type).refuel(argument);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            }else {
                System.out.println(vehicleMap.get(type).drive(argument));
            }
        }
        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle.toString());
        }
    }
}
