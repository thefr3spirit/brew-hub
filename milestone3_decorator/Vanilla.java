package milestone3_decorator;

public class Vanilla extends CondimentDecorator {
    
    public Vanilla(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Vanilla";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1000;
    }
}