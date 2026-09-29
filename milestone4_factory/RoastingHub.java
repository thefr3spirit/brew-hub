package milestone4_factory;

public abstract class RoastingHub {
    protected IngredientFactory factory;

    protected abstract Beans createBeans();

    public void setIngredientFactory(IngredientFactory factory) {
        this.factory = factory;
    }

    public void prepareDrink() {
        Beans beans = createBeans();
        Milk milk = factory.createMilk();
        Cup cup = factory.createCup();

        System.out.println("Preparing drink with " + beans.getName() + ", " + milk.getName() + ", and " + cup.getName());
    }
}