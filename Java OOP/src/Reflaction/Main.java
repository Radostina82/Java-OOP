package Reflaction;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> clazz = Reflection.class;
        // System.out.println(clazz);
        // System.out.println(clazz.getSuperclass());
       /* Class<?> [] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }*/
        Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
        Reflection reflection = ctor.newInstance();
        // System.out.println(reflection.toString());
        Method[] declaredMethods = clazz.getDeclaredMethods();

        //  Arrays.stream(declaredMethods).filter(m-> m.getName().contains("set") || m.getName().contains("get")).sorted(Comparator.comparing(m-> m.getName())).
        //        forEach(Main::printMethod);

        Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.stream(declaredFields).sorted(Comparator.comparing(Field::getName)).filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));
        Arrays.stream(declaredMethods).filter(m -> m.getName().contains("set") || m.getName().contains("get")).sorted(Comparator.comparing(m -> m.getName())).
                forEach(Main::printMethods);

    }

    public static void printMethods(Method method) {
        String out = "";
        if (method.getName().contains("set") && !Modifier.isPrivate(method.getModifiers())) {
            out = String.format("%s have to be private!", method.getName());
        } else if (method.getName().contains("get") && !Modifier.isPublic(method.getModifiers())) {
            out = String.format("%s have to be public!", method.getName());
        }else {
            return;
        }
        System.out.println(out);
    }

    public static void printMethod(Method method) {
        String out = method.getName().contains("set") ? String.format("%s and will set field of %s", method.getName(), formatType(method.getParameterTypes()[0]))
                : String.format("%s will return %s", method.getName(), formatType(method.getReturnType()));
        System.out.println(out);
    }

    public static String formatType(Class<?> type) {
        return type == int.class ? "class " + type : type.toString();
    }
}
