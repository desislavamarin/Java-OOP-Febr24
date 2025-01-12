package L07_ReflectionAndAnnotation.P01_Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        Class<?> reflectionClass = Reflection.class;
        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());
        Arrays.stream(reflectionClass.getInterfaces())
                .forEach(System.out::println);
        System.out.println(reflectionClass.getDeclaredConstructor().newInstance());
    }
}
