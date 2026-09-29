package milestone5_singleton;

import milestone2_observer.Observer;
import milestone2_observer.OrderStatusPublisher;

public class OrderLedger implements Observer {
    private static final OrderLedger instance = new OrderLedger();
    private OrderStatusPublisher publisher;

    private double totalRevenue;
    private int transactionCount;

    private OrderLedger() {}

    public void subscribeToPublisher(OrderStatusPublisher publisher) {
        this.publisher = publisher;
        publisher.registerObserver(this);
    }

    @Override
    public void update() {
        if ("ready".equals(publisher.getOrderStatus())) {
            recordTransaction(publisher.getOrderAmount());
        }
    }

    public static OrderLedger getInstance() {
        return instance;
    }

    public synchronized void recordTransaction(double amount) {
        totalRevenue += amount;
        transactionCount++;
    }

    public synchronized double getTotalRevenue() {
        return totalRevenue;
    }

    public synchronized int getTransactionCount() {
        return transactionCount;
    }
}