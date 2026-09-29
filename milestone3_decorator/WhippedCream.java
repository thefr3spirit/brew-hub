package milestone3_decorator;

public class WhippedCream extends CondimentDecorator {
    
    public WhippedCream(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whipped Cream";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1500;
    }
}