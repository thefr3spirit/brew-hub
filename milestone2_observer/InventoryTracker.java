package milestone2_observer;

public class InventoryTracker implements Observer {
    OrderStatusPublisher publisher;

    public InventoryTracker(OrderStatusPublisher publisher) {
        this.publisher = publisher;
        publisher.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Inventory Tracker: Order " + publisher.getOrderId() + " is now " + publisher.getOrderStatus());
    }
}