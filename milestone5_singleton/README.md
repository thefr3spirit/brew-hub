# Milestone 5: Singleton

## The problem
BrewHub needs exactly one `OrderLedger` recording every paid transaction across all hubs, so accounting can reconcile revenue. Each hub's checkout runs on its own thread, so the ledger must also be safe when several threads use it at the same time.

## The design
I used the **Singleton pattern**, following the ChocolateBoiler example in Chapter 5 of Head First.

- **Private constructor** — nobody outside the class can call `new OrderLedger()`.
- **`private static final OrderLedger instance = new OrderLedger();`** — the one and only ledger, created when the class is loaded.
- **`getInstance()`** — returns that one instance to anyone who asks.
- **`recordTransaction()`** and the getters are `synchronized`, so two hubs recording a payment at the same moment can't overwrite each other's update.

## Which thread-safety fix, and why
I chose **eager creation**.

`getInstance()` is called on every checkout, on every hub's thread, so it is called very often. With the `synchronized` fix, every one of those calls would have to wait its turn for a lock, even though the ledger only needs to be created once. Double-checked locking avoids that, but it is harder to write and easy to get wrong.

Eager creation is the simplest safe option: the JVM creates the ledger once when the class loads, before any thread can ask for it, so `getInstance()` just returns it with no locking at all. The usual downside of eager creation — creating the object even if it's never used — doesn't matter here, because BrewHub always needs the ledger.

Note: eager creation only makes *creating* the ledger thread-safe. Updating it is a separate problem, which is why `recordTransaction()` is still `synchronized`.

## Bonus: what would go wrong without a Singleton
If each hub could call `new OrderLedger()`, each would get its own ledger. Seattle's payments would go into one ledger and Bogotá's into another, so no single ledger would show the real total revenue. If some code recorded a payment into its own ledger and another part recorded the same payment into a different one, adding the ledgers up at reconciliation would count that revenue twice — the same kind of bug as two ChocolateBoiler objects both thinking the boiler is empty and filling it twice.

## The demo
1. Calls `getInstance()` twice and shows both references are the same object (`Same ledger? true`).
2. Starts three threads (Seattle, Bogotá, Kampala) that each record 1000 payments of 10 at the same time, then shows the ledger has exactly 3000 transactions and 30000.0 revenue — no payment was lost.

## How to run
From the `BrewHub` folder:
```
javac milestone5_singleton\*.java
java milestone5_singleton.Demo
```