package milestone3_decorator;

public class ExtraShot extends CondimentDecorator {
    
    public ExtraShot(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Extra Shot";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3000;
    }
}