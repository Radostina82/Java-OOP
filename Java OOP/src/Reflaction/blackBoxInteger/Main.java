package Reflaction.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructors = clazz.getDeclaredConstructor();
        constructors.setAccessible(true);
        Method[] declaredMethods = clazz.getDeclaredMethods();
        BlackBoxInt blackBoxInt = constructors.newInstance();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");

            if (tokens[0].equals("add")) {
                printResult(blackBoxInt, input, declaredMethods);
            }else if (tokens[0].equals("subtract")){
                printResult(blackBoxInt, input, declaredMethods);
            }else if (tokens[0].equals("divide")){
                printResult(blackBoxInt, input, declaredMethods);
            }else if (tokens[0].equals("multiply")){
                printResult(blackBoxInt, input, declaredMethods);
            }else if (tokens[0].equals("rightShift")){
                printResult(blackBoxInt, input, declaredMethods);
            }else if (tokens[0].equals("leftShift")){
                printResult(blackBoxInt, input, declaredMethods);
            }
            input = scanner.nextLine();
        }
    }

    private static void printResult(BlackBoxInt blackBoxInt, String input, Method[] methods) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        String[] tokens = input.split("_");
        Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
        innerValue.setAccessible(true);
        Method currentMethod = Arrays.stream(methods).filter(m -> m.getName().equals(tokens[0])).findFirst().orElse(null);

        if (currentMethod != null) {
            currentMethod.setAccessible(true);
         currentMethod.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
            System.out.println(innerValue.get(blackBoxInt));
        }
    }
}
