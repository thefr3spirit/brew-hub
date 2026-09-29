package milestone1_strategy;

public class NoDiscount implements PricingStrategy {
    @Override
    public double calculateTotal(double subtotal) {
        return subtotal;
    }
}