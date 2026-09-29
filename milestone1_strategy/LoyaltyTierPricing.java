package milestone1_strategy;

public class LoyaltyTierPricing implements PricingStrategy {
    // Discount depends on the customer's loyalty tier, e.g. 0.10 for Silver, 0.20 for Gold
    private final double discountRate;

    public LoyaltyTierPricing(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotal(double subtotal) {
        return subtotal * (1 - discountRate);
    }
}
