package milestone4_factory;

public class SeattleHub extends RoastingHub {
    public SeattleHub() {
        factory = new SeattleIngredientFactory();
    }

    @Override
    protected Beans createBeans() {
        return factory.createBeans();
    }
}