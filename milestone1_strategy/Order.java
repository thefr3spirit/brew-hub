package milestone1_strategy;

public class Order {
    private double subtotal;
    private PricingStrategy pricingStrategy;


    public Order(double subtotal, PricingStrategy pricingStrategy) {
        this.subtotal = subtotal;
        this.pricingStrategy = pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double getTotal() {
        return pricingStrategy.calculateTotal(subtotal);
    }
}