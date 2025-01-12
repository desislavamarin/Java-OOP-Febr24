package Ex07_ReflectionAndAnnotation.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        //създаваме reflection
        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        //извикваме всички private конструктори
        Constructor<BlackBoxInt> privateConstructor = blackBoxIntClass.getDeclaredConstructor();
        // преобразуваме ги в public, за да му вдигаме инстанция
        privateConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = privateConstructor.newInstance();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("_");
            String methodName= tokens[0];
            int parameter = Integer.parseInt(tokens[1]);

            //взимаме всички методи в класа, като в (името, вида който връща)
            Method method = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            //извикваме метода (подаваме инстанция, параметър)
            method.invoke(blackBoxInt, parameter);

            //print value
            Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }

    }
}
