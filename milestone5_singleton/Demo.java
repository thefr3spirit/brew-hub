package milestone5_singleton;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

       
        System.out.println("--- One ledger ---");
        OrderLedger a = OrderLedger.getInstance();
        OrderLedger b = OrderLedger.getInstance();
        System.out.println("Same ledger? " + (a == b));

        // 2. Three hubs check out at the same time, each on its own thread
        System.out.println("--- Three hubs record 1000 payments of 10 each, at the same time ---");
        Thread seattle = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                OrderLedger.getInstance().recordTransaction(10);
            }
        });
        Thread bogota = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                OrderLedger.getInstance().recordTransaction(10);
            }
        });
        Thread kampala = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                OrderLedger.getInstance().recordTransaction(10);
            }
        });

        seattle.start();
        bogota.start();
        kampala.start();

        // wait for all three hubs to finish
        seattle.join();
        bogota.join();
        kampala.join();

        OrderLedger ledger = OrderLedger.getInstance();
        System.out.println("Transactions: " + ledger.getTransactionCount() + " (expected 3000)");
        System.out.println("Total revenue: " + ledger.getTotalRevenue() + " (expected 30000.0)");
    }
}
