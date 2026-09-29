package milestone3_decorator;

public class Demo {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new OatMilk(beverage);
        beverage = new Vanilla(beverage);
        beverage = new WhippedCream(beverage);
        beverage = new Chocolate(beverage);
        beverage = new Caramel(beverage);

        System.out.println(beverage.getDescription());
        System.out.println("Cost: " + beverage.cost());

        Beverage beverage2 = new Bushera();
        beverage2 = new ExtraShot(beverage2);
        beverage2 = new Caramel(beverage2);
        beverage2 = new Caramel(beverage2);

        System.out.println(beverage2.getDescription());
        System.out.println("Cost: " + beverage2.cost());
    }
}