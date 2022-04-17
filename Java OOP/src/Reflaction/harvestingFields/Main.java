package Reflaction.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Field[] declaredFields = RichSoilLand.class.getDeclaredFields();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("HARVEST")){
            printField(declaredFields, input);
            input= scanner.nextLine();
        }
    }
    private static void printField(Field[] fields, String input){
        if (input.equals("protected")){
            Arrays.stream(fields).filter(f-> Modifier.isProtected(f.getModifiers())).forEach(f -> System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()),f.getType().getSimpleName(), f.getName()));
        }else if (input.equals("private")){
            Arrays.stream(fields).filter(f-> Modifier.isPrivate(f.getModifiers())).forEach(f -> System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()),f.getType().getSimpleName(), f.getName()));
        }else if (input.equals("public")){
            Arrays.stream(fields).filter(f-> Modifier.isPublic(f.getModifiers())).forEach(f -> System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()),f.getType().getSimpleName(), f.getName()));
        }else {
            Arrays.stream(fields).forEach(f -> System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()),f.getType().getSimpleName(), f.getName()));
        }

    }
}
