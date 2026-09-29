# Milestone 3 — Decorator Pattern: Build-Your-Own Drinks

## The problem
Customers can add any mix of condiments to any base drink, and the number of combinations is unlimited. Making a subclass for every combination would mean hundreds of classes, and every new condiment or price change would mean editing many of them.

## The design
I used the **Decorator pattern**, the same design as Starbuzz Coffee in Chapter 3 of Head First.

- **`Beverage`** — abstract class with a `description`, `getDescription()` and an abstract `cost()`.
- **`CondimentDecorator`** — abstract class that *extends* `Beverage` and also *holds* a `Beverage`. Because it is a `Beverage`, a decorated drink can be wrapped again and again.
- **`Espresso`, `Drip`, `Bushera`** — the base drinks. Each sets its own description and returns its own price.
- **`OatMilk`, `ExtraShot`, `Vanilla`, `WhippedCream`, `Caramel`, `Chocolate`** — the condiments (decorators). Each wraps a drink.

## How cost() and getDescription() work
Each condiment asks the drink inside it for its answer, then adds its own part:
- `cost()` returns `beverage.cost()` plus the condiment's own price.
- `getDescription()` returns `beverage.getDescription()` plus `", <condiment name>"`.



## What I added
- New beverage: **Bushera**
- New condiments: **Caramel** and **Chocolate**

None of the existing classes had to change to add them.

## One thing this makes easy
Adding the same condiment more than once. The demo makes a Bushera with double caramel just by wrapping it in `Caramel` twice. With subclasses, "double caramel" would need yet another class for every drink. New condiments are also easy: write one new decorator class and it works with every drink.

This follows the book's **Open-Closed Principle**: *classes should be open for extension, but closed for modification.*

## How to run
From the `BrewHub` folder:
```
javac milestone3_decorator\*.java
java milestone3_decorator.Demo
```
