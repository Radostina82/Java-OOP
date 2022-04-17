package InterfacesAndAbstraction.DefineAnInterfacePerson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      /*  Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            methods = Identifiable.class.getDeclaredMethods();
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthDate = scanner.nextLine();
            Identifiable identifiable = new Citizen(name,age,id,birthDate);
            Birthable birthable = new Citizen(name,age,id,birthDate);
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
        }*/
        Scanner scanner = new Scanner(System.in);
       /* String input = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            Birthable birthable;
            if (type.equals("Citizen")) {
                birthables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]),tokens[3],tokens[4]));
            } else if (type.equals("Pet")) {
            birthables.add(new Pet(tokens[1], tokens[2]));
            } else if (type.equals("Robot")) {
                robots.add(new Robot(tokens[1], tokens[2]));
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        boolean isFind = false;
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(input)){
                System.out.println(birthable.getBirthDate());
                isFind = true;
            }
        }
        if (!isFind){
            System.out.println("<no output>");
        }*/
    }

}
