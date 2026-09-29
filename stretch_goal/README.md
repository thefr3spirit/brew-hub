# Stretch Goal: Singleton + Observer

## The goal
Wire Milestones 2 and 5 together: the `OrderLedger` Singleton subscribes as an Observer to `OrderStatusPublisher`, and only records a transaction once an order reaches "ready".

## How the two patterns meet
- **Singleton (Milestone 5)** — there is still exactly one `OrderLedger`, so every paid order across all hubs goes into the same place.
- **Observer (Milestone 2)** — `OrderLedger` now `implements Observer`, so it is just one more subscriber to `OrderStatusPublisher`, alongside the kitchen display, customer notifier and inventory tracker.

When an order's status changes, the publisher notifies all its observers. The ledger's `update()` pulls the status from the publisher, ignores "queued" and "brewing", and only calls `recordTransaction()` when the status is "ready".

No code was copied between milestones — the stretch demo imports and reuses the Milestone 2 and 5 classes directly.

## Changes made to earlier milestones
**`OrderStatusPublisher` (Milestone 2)**
- Added an `orderAmount` field and `getOrderAmount()`.
- Added `setOrderStatus(orderId, status, amount)`, which saves the amount and then calls the original `setOrderStatus(orderId, status)`.

Because I chose the **pull** model in Milestone 2, adding the amount did not require any change to the `Observer` interface or to the three existing observers — they simply don't ask for it. The Milestone 2 demo still runs unchanged. This is exactly the benefit of pull I described in that milestone's README.

**`OrderLedger` (Milestone 5)**
- Now `implements Observer`.
- Added `subscribeToPublisher(publisher)`, which stores the publisher and registers the ledger with it.
- Added `update()`, which records the order's amount only when its status is "ready".

## Why `subscribeToPublisher()` instead of the constructor
The other observers register themselves in their constructors. The ledger can't: as a Singleton, its constructor is private, takes no arguments, and runs when the class loads — before any publisher exists. So it needs a separate method to be told which publisher to listen to.

## The demo
1. Creates a publisher, a kitchen display, and subscribes the ledger.
2. Moves order A1 (5000) through queued → brewing → ready. The ledger stays at 0 until "ready", then shows 1 transaction / 5000.
3. Moves order A2 (3000) through queued → ready. The ledger ends at 2 transactions / 8000.

## How to run
From the `BrewHub` folder:
```
javac milestone2_observer\*.java milestone5_singleton\*.java stretch_goal\*.java
java stretch_goal.Demo
```

Expected output:
```
--- Order A1 (5000) ---
Kitchen Display: Order A1 is now queued
  Ledger: 0 transactions, total 0.0
Kitchen Display: Order A1 is now brewing
  Ledger: 0 transactions, total 0.0
Kitchen Display: Order A1 is now ready
  Ledger: 1 transactions, total 5000.0
--- Order A2 (3000) ---
Kitchen Display: Order A2 is now queued
  Ledger: 1 transactions, total 5000.0
Kitchen Display: Order A2 is now ready
  Ledger: 2 transactions, total 8000.0
```
