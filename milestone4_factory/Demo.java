package milestone4_factory;

public class Demo {
    public static void main(String[] args) {
        RoastingHub seattle = new SeattleHub();
        RoastingHub kampala = new KampalaHub();
        RoastingHub bogota = new BogotaHub();

        System.out.println("--- Seattle hub ---");
        seattle.prepareDrink();

        System.out.println("--- Kampala hub ---");
        kampala.prepareDrink();

        System.out.println("--- Bogota hub ---");
        bogota.prepareDrink();

        System.out.println("--- Seattle hub swapped to Bogota factory ---");
        seattle.setIngredientFactory(new BogotaIngredientFactory());
        seattle.prepareDrink();
    }
}
