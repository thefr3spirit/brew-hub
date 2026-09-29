package milestone4_factory;

public class BogotaIngredientFactory implements IngredientFactory {
    @Override
    public Beans createBeans() {
        return new BogotaBeans();
    }

    @Override
    public Milk createMilk() {
        return new BogotaMilk();
    }

    @Override
    public Cup createCup() {
        return new BogotaCup();
    }
}