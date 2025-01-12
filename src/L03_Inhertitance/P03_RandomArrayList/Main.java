package L03_Inhertitance.P03_RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<String> words = new RandomArrayList<String>();

        words.add("10");
        words.add("20");
        words.add("30");

        System.out.println(words.getRandomElement());
        System.out.println(words.getRandomElement());
        System.out.println(words.getRandomElement());
    }
}
