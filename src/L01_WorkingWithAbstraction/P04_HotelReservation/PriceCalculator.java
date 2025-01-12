package L01_WorkingWithAbstraction.P04_HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberDays;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int numberDays, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberDays = numberDays;
        this.season = season;
        this.discount = discount;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getNumberDays() {
        return numberDays;
    }

    public void setNumberDays(int numberDays) {
        this.numberDays = numberDays;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double calculatePrice(double pricePerDay, int numberDays, Season season, Discount discount) {
        int multiplier = season.getValue();
        double discountType = discount.getValue() / 100.0;

        double price = pricePerDay * numberDays * multiplier;
        double discountPrice = price * discountType;
        return price - discountPrice;
    }
}
