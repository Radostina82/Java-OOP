package WorkingWithAbstraction.HotelReservation;

import java.util.Scanner;
import java.util.function.Predicate;

import static Input.Reader.readStringArray;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = readStringArray("\\s+");
        double price = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Discount discount = Discount.parseDiscount(input[3]);
        Season season = Season.valueOf(input[2].toUpperCase());
        PriceCalculator calculator = new PriceCalculator(season, discount, price, days);
        System.out.printf("%.2f",calculator.calculatePrice());
    }
}
