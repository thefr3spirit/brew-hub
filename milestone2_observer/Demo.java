package milestone2_observer;

public class Demo {
    public static void main(String[] args) {

        OrderStatusPublisher publisher = new OrderStatusPublisher();


        System.out.println("\n=== Kitchen Display subscribes ===");
        KitchenDisplay kitchenDisplay = new KitchenDisplay(publisher);

        System.out.println("\n=== Customer Notifier subscribes ===");
        CustomerNotifier customerNotifier = new CustomerNotifier(publisher);
       
        
        publisher.setOrderStatus("A1", "queued");

        System.out.println("\n=== Inventory Tracker subscribes ===");
        InventoryTracker inventoryTracker = new InventoryTracker(publisher);

        publisher.setOrderStatus("A1", "brewing");

        System.out.println("\n=== Kitchen Display unsubscribes ===");
        publisher.removeObserver(kitchenDisplay);

        System.out.println("\n=== Inventory Tracker unsubscribes ===");
        publisher.removeObserver(inventoryTracker);

        publisher.setOrderStatus("A1", "ready");
    }
}