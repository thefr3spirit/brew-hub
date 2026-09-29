package milestone3_decorator;

public class OatMilk extends CondimentDecorator {
    
    public OatMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Oat Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2000;
    }
}