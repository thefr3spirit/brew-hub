# Milestone 1 — Strategy Pattern: Pricing

## The problem
BrewHub has several discount schemes , and more will be added over time. The first draft put all of them in one big if/else chain inside the `Order` class , so every new discount meant editing `Order` again, and the class kept growing.

## The design
I used the **Strategy pattern** same idea as `FlyBehavior` and `QuackBehavior` in SimUDuck from the HeadFirst book.

- **`PricingStrategy`** — the interface. Every pricing rule has one method: `calculateTotal(subtotal)`.

- **`NoDiscount`, `StudentDiscount`, `HappyHourPricing`, `LoyaltyTierPricing`** — the concrete strategies. Each class holds exactly one pricing rule. `LoyaltyTierPricing` takes its discount rate in the constructor, so the same class covers different tiers.

- **`Order`** It holds a `PricingStrategy` and, in `getTotal()`, simply asks that strategy to calculate the total. It has no if/else and doesn't know which discount it is using.

- **`setPricingStrategy()`** — lets an order change its strategy while the program is running (e.g. a customer is upgraded from Silver to Gold mid-session). The demo shows one order switching through all the strategies.

Design principles from the book used here:
- *Encapsulate what varies* — the pricing rules change often, so they are pulled out of `Order`.
- *Program to an interface* — `Order` only knows about `PricingStrategy`.
- *Favor composition over inheritance* — an order *has a* pricing strategy instead of there being `StudentOrder`, `HappyHourOrder`, etc.

## Adding a new discount
Write one new class that implements `PricingStrategy`. `Order` and the other strategies do not change at all.

## Why not just use if/else?
- With if/else, every new discount means opening the `Order` class and adding another branch, so the class keeps growing and any edit risks breaking what already worked. With Strategy planning, the `Order` class never changes when a new discount is added.
- It also mixes all the pricing rules together in one place, which makes them harder to read and test. With the Strategy pattern, each rule lives in its own small class.  
- The strategy can also be swapped while the program is running, which an if/else hard-coded into `Order` doesn't handle.

## How to run
From the `BrewHub` folder:
```
javac milestone1_strategy\*.java
java milestone1_strategy.BrewHubDemo
```

Expected output:
```
No discount: 5000.0
Student: 4500.0
Happy hour: 4000.0
Loyalty Silver: 4500.0
Loyalty Gold: 4000.0
```
