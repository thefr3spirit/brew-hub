package milestone4_factory;

public class KampalaIngredientFactory implements IngredientFactory {
    @Override
    public Beans createBeans() {
        return new KampalaBeans();
    }

    @Override
    public Milk createMilk() {
        return new KampalaMilk();
    }

    @Override
    public Cup createCup() {
        return new KampalaCup();
    }
}