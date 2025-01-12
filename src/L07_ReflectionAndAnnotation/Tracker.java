package L07_ReflectionAndAnnotation;


import java.util.Arrays;

public class Tracker {
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
    @Author(name = "Peter")

    public static void printMethodsByAuthor(Class<?> cl) {
        Arrays.stream(cl.getDeclaredMethods()).filter(method -> method.isAnnotationPresent(Author.class)).forEach(method -> {
            System.out.println(method.getAnnotation(Author.class).name() + ": " + method.getName());
        });
    }
}
