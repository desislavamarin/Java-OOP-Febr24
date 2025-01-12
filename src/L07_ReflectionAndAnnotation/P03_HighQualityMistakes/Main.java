package L07_ReflectionAndAnnotation.P03_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Field[] fields = Reflection.class.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Method[] declaredMethods = Reflection.class.getDeclaredMethods();
        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        for (Method declaredMethod : declaredMethods) {
            boolean hasGetPrefix = declaredMethod.getName().startsWith("get");
            boolean hasZeroParameters = declaredMethod.getParameterTypes().length == 0;
            boolean isVoid = declaredMethod.getReturnType().getSimpleName().equalsIgnoreCase("void");
            if (hasGetPrefix && hasZeroParameters && !isVoid) {
                getters.add(declaredMethod);
            }

            boolean hasSetPrefix = declaredMethod.getName().startsWith("set");
            boolean hasOneParameters = declaredMethod.getParameterTypes().length == 1;
            if (hasSetPrefix && hasOneParameters && isVoid) {
                setters.add(declaredMethod);
            }
        }

        getters.stream()
                .filter(g -> !Modifier.isPublic(g.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(g -> System.out.printf("%s have to be public!%n", g.getName()));

        setters.stream()
                .filter(g -> !Modifier.isPrivate(g.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(g -> System.out.printf("%s have to be private!%n", g.getName()));
    }
}
