package Ex01_WorkingWithAbstraction.P01_CardSuit;

public enum CardSuits {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    public static void printCardSuits() {
        System.out.println("Card Suits:");
        for (CardSuits cardSuits : CardSuits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuits.ordinal(), cardSuits);
        }
    }
}
