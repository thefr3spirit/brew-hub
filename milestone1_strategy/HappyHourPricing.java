package milestone1_strategy;

public class HappyHourPricing implements PricingStrategy {
    // Apply a 20% discount during happy hour
    private static final double DISCOUNT_RATE = 0.20;

    @Override
    public double calculateTotal(double subtotal) {
        return subtotal * (1 - DISCOUNT_RATE);
    }
}