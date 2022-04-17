package WorkingWithAbstraction.HotelReservation;

public enum Discount {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);

    private final int percentage;

    Discount(int percentage) {
        this.percentage = percentage;
    }

    public int getDiscount(){
        return this.percentage;
    }

    public static Discount parseDiscount(String discount){
        if (discount.equals("VIP")){
            return VIP;
        }else if (discount.equals("SecondVisit")){
            return SECOND_VISIT;
        }else if (discount.equals("None")){
            return NONE;
        }
        throw new IllegalArgumentException("Unknown discount type" + discount);
    }
}
