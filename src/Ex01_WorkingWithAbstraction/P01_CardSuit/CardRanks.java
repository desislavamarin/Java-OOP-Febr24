package Ex01_WorkingWithAbstraction.P01_CardSuit;

public enum CardRanks {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    public static void printCardRanks() {
        System.out.println("Card Ranks:");
        for (CardRanks cardRanks : CardRanks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardRanks.ordinal(), cardRanks);
        }
    }
}
