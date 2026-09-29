# Milestone 2 — Observer Pattern: Order Status Updates

## The problem
Every order moves through states (queued, brewing, ready), and three systems need to react when that happens: the kitchen display, the customer's app, and the inventory tracker. If the order code called each of these directly, it would need to know about every one of them, and adding a new system would mean editing that code again.

## The design
I used the **Observer pattern**, the same idea as the Weather Station in Chapter 2 of Head First (`WeatherData` notifying its displays).

- **`Subject`** — interface with `registerObserver`, `removeObserver` and `notifyObservers`.
- **`Observer`** — interface with a single `update()` method.
- **`OrderStatusPublisher`** — the concrete subject. It keeps a list of observers and the current order ID and status. When `setOrderStatus()` is called, it saves the new values and calls `update()` on every observer in the list.
- **`KitchenDisplay`, `CustomerNotifier`, `InventoryTracker`** — the concrete observers. Each one reacts to the update in its own way.

The publisher only knows that its observers are `Observer`s, it doesn't know what they are or what they do. This follows the book's principle: *strive for loosely coupled designs between objects that interact.*

## Subscribing and unsubscribing
Each observer registers itself in its constructor by calling `publisher.registerObserver(this)`. An observer is removed with `publisher.removeObserver(...)`.

The demo shows this happening while the program runs:
1. Kitchen and Customer subscribe, and both receive "queued".
2. Inventory subscribes later, and all three receive "brewing".
3. Kitchen and Inventory unsubscribe, and only Customer receives "ready".

## Push vs. pull
I chose **pull**. The publisher's `update()` sends no data; it only tells observers that something changed. Each observer keeps a reference to the publisher and asks for what it needs using `getOrderId()` and `getOrderStatus()`.

Push would have been simpler here, since the data is small. I chose pull because it copes better with change: if BrewHub later adds more order data (for example a customer name or drink size), I only add a getter to the publisher. The `Observer` interface and the existing observers don't need to change, and each observer can take only the data it actually uses.

## Adding a new observer
Write one new class that implements `Observer` and registers with the publisher. `OrderStatusPublisher` and the other observers do not change.

## How to run
From the `BrewHub` folder:
```
javac milestone2_observer\*.java
java milestone2_observer.Demo
```
