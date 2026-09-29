package milestone1_strategy;

public class BrewHubDemo {
    public static void main(String[] args) {

        
        Order order = new Order(5000, new NoDiscount());
        System.out.println("No discount: " + order.getTotal());

        
        order.setPricingStrategy(new StudentDiscount());
        System.out.println("Student: " + order.getTotal());

        
        order.setPricingStrategy(new HappyHourPricing());
        System.out.println("Happy hour: " + order.getTotal());

        
        order.setPricingStrategy(new LoyaltyTierPricing(0.10));
        System.out.println("Loyalty Silver: " + order.getTotal());

        
        order.setPricingStrategy(new LoyaltyTierPricing(0.20));
        System.out.println("Loyalty Gold: " + order.getTotal());
    }
}
