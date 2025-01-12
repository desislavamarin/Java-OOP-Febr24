package L01_WorkingWithAbstraction.P04_HotelReservation;

public enum Discount {
    VIP(20),
    SecondVisit(10),
    None(0);

    private int value;

    Discount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
