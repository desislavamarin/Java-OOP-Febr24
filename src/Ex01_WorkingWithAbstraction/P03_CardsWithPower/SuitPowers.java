package Ex01_WorkingWithAbstraction.P03_CardsWithPower;

public enum SuitPowers {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private final int value;

    SuitPowers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
