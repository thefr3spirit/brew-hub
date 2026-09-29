package milestone4_factory;

public class SeattleIngredientFactory implements IngredientFactory {
    @Override
    public Beans createBeans() {
        return new SeattleBeans();
    }

    @Override
    public Milk createMilk() {
        return new SeattleMilk();
    }

    @Override
    public Cup createCup() {
        return new SeattleCup();
    }
}