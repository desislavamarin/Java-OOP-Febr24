package L07_ReflectionAndAnnotation.P02_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflectionClass = Reflection.class;
        Method[] declaredMethods = reflectionClass.getDeclaredMethods();
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

        getters.stream().sorted(Comparator.comparing(Method::getName))
                .forEach(m -> {
                    String format = "%s will return class %s%n";
                    System.out.println(String.format(format, m.getName(), m.getReturnType()));
                });

        setters.stream().sorted(Comparator.comparing(Method::getName))
                .forEach(m -> {
                    String format = "%s and will set field of class %s";
                    System.out.println(String.format(format, m.getName(), m.getParameterTypes()[0].getSimpleName()));
                });
    }
}
