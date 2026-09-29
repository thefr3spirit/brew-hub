# Milestone 4: Factory Method and Abstract Factory
## The problem
BrewHub has roasting hubs in different regions, and each hub must use its own region's beans, milk and cups. Mixing parts from different regions (e.g. Seattle beans with a Bogota cup) breaks a sourcing contract. If each hub created its parts with `new` wherever it needed them, nothing would stop that kind of mix-up.

## The design
This follows the PizzaStore example from Chapter 4 of Head First, which uses both patterns together.

**Abstract Factory — a whole family of parts per region**
- **`Beans`, `Milk`, `Cup`** interfaces for the parts.
- **`SeattleBeans`, `BogotaMilk`, `KampalaCup`, ...** the concrete parts, three per region.
- **`IngredientFactory`**  interface with `createBeans()`, `createMilk()` and `createCup()`.
- **`SeattleIngredientFactory`, `BogotaIngredientFactory`, `KampalaIngredientFactory`**  each one can only make its own region's parts.

**Factory Method — each hub creates its own beans**
- **`RoastingHub`** — abstract class. `prepareDrink()` does the work, but leaves one step, `createBeans()`, as an abstract method for subclasses to fill in.
- **`SeattleHub`, `BogotaHub`, `KampalaHub`** — each sets its region's factory in its constructor and implements `createBeans()`.

## Why parts can never be mixed
A hub gets all three parts, beans, milk and cup from the same factory object, and each factory can only make parts from one region. `createBeans()` also asks the factory for the beans instead of using `new SeattleBeans()` directly.

The demo swaps the Seattle hub's factory to the Bogotá factory. The result is all Bogotá parts — the whole family changes together, so a mixed combination is impossible.

## Adding a new region
I added **Kampala** as the third region. It only needed new classes: `KampalaBeans`, `KampalaMilk`, `KampalaCup`, `KampalaIngredientFactory` and `KampalaHub`. No existing class had to change.

## Design principle
The **Dependency Inversion Principle**: *"Depend upon abstractions. Do not depend upon concrete classes."*

`RoastingHub` only knows about `Beans`, `Milk`, `Cup` and `IngredientFactory` — never `SeattleBeans` or `BogotaIngredientFactory`. The concrete classes are chosen by the subclasses and factories, so the hub code doesn't depend on any particular region.

## How to run
From the `BrewHub` folder:
```
javac milestone4_factory\*.java
java milestone4_factory.Demo
```