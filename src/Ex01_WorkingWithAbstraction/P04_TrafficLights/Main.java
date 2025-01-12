package Ex01_WorkingWithAbstraction.P04_TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

import static Ex01_WorkingWithAbstraction.P04_TrafficLights.Signals.printSignals;
import static Ex01_WorkingWithAbstraction.P04_TrafficLights.Signals.updateSignal;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Signals[] signals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Signals::valueOf)
                .toArray(Signals[]::new);

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            updateSignal(signals);
            printSignals(signals);
        }
    }
}
