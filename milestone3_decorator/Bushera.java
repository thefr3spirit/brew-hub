package milestone3_decorator;

public class Bushera extends Beverage {
    public Bushera() {
        description = "Bushera brewed with coffee";
    }

    @Override
    public double cost() {
        return 8000;
    }
}