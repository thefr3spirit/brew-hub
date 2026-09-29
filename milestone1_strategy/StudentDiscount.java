package milestone1_strategy;

public class StudentDiscount implements PricingStrategy {
    // Apply a 10% discount for students
    private static final double DISCOUNT_RATE = 0.10;

    @Override
    public double calculateTotal(double subtotal) {
        return subtotal * (1 - DISCOUNT_RATE);
    }
}