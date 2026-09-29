package milestone4_factory;

public class KampalaHub extends RoastingHub {
    public KampalaHub() {
        factory = new KampalaIngredientFactory();
    }

    @Override
    protected Beans createBeans() {
        return factory.createBeans();
    }
}