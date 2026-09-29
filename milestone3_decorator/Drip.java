package milestone3_decorator;

public class Drip extends Beverage {
    public Drip() {
        description = "Drip";
    }

    @Override
    public double cost() {
        return 7000;
    }
}