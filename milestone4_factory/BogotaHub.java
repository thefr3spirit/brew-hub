package milestone4_factory;

public class BogotaHub extends RoastingHub {
    public BogotaHub() {
        factory = new BogotaIngredientFactory();
    }

    @Override
    protected Beans createBeans() {
        return factory.createBeans();
    }
}