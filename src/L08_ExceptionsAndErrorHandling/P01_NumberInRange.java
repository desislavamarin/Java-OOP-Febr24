package L08_ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class P01_NumberInRange {
    private static int start = 0;
    private static int end = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = Arrays.stream(scanner.nextLine().
                        split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        start = range[0];
        end = range[1];
        System.out.println("Range: [" + start + "..." + end + "]");

        while (true) {
            //прочитаме входните данни
            String input = scanner.nextLine();
            try {
                //опитване да конвентираме стринг-а в инт
                int num = Integer.parseInt(input);
                //ако го направим -> проверяваме дали е в границата
                if (isInRange(num)) {
                    //изписваме че е валидно
                    System.out.println("Valid number: " + num);
                    //приключваме програмата
                    return;
                } else {
                    System.out.println("Invalid number: " + input);
                }
                //ако това не се изпълни
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + input);
            }
        }
    }

    private static boolean isInRange(int num) {
        return  start<= num && num <= end;
    }
}
