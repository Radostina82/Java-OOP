package WorkingWithAbstraction.HotelReservation;

public class PriceCalculator {
    private final Season season;
    private final Discount discount;
    private final double pricePerDay;
    private final int days;

    public PriceCalculator(Season season, Discount discount, double pricePerDay, int days) {
        this.season = season;
        this.discount = discount;
        this.pricePerDay = pricePerDay;
        this.days = days;
    }
    public double calculatePrice(){
        double price = this.days * this.pricePerDay * this.season.getValue();
        return  price- (price * this.discount.getDiscount()/100);
    }
}
