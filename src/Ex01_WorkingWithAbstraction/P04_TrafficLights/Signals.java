package Ex01_WorkingWithAbstraction.P04_TrafficLights;

public enum Signals {
    RED,
    GREEN,
    YELLOW;

    public static void printSignals(Signals[] signals) {
        for (Signals signal : signals) {
            System.out.print(signal + " ");
        }
        System.out.println();
    }

    public static void updateSignal(Signals[] signals) {
        for (int i = 0; i < signals.length; i++) {
            switch (signals[i]) {
                case RED:
                    signals[i] = Signals.GREEN;
                    break;
                case GREEN:
                    signals[i] = Signals.YELLOW;
                    break;
                case YELLOW:
                    signals[i] = Signals.RED;
                    break;
            }
        }
    }
}
