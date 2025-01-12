package L01_WorkingWithAbstraction.P04_HotelReservation;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int value;

    Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
