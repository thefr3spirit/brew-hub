package stretch_goal;

import milestone2_observer.KitchenDisplay;
import milestone2_observer.OrderStatusPublisher;
import milestone5_singleton.OrderLedger;

public class Demo {
    public static void main(String[] args) {
        OrderStatusPublisher publisher = new OrderStatusPublisher();
        new KitchenDisplay(publisher);

        // the Singleton ledger subscribes as an Observer
        OrderLedger ledger = OrderLedger.getInstance();
        ledger.subscribeToPublisher(publisher);

        System.out.println("--- Order A1 (5000) ---");
        publisher.setOrderStatus("A1", "queued", 5000);
        printLedger(ledger);
        publisher.setOrderStatus("A1", "brewing", 5000);
        printLedger(ledger);
        publisher.setOrderStatus("A1", "ready", 5000);
        printLedger(ledger);

        System.out.println("--- Order A2 (3000) ---");
        publisher.setOrderStatus("A2", "queued", 3000);
        printLedger(ledger);
        publisher.setOrderStatus("A2", "ready", 3000);
        printLedger(ledger);
    }

    private static void printLedger(OrderLedger ledger) {
        System.out.println("  Ledger: " + ledger.getTransactionCount()
                + " transactions, total " + ledger.getTotalRevenue());
    }
}
