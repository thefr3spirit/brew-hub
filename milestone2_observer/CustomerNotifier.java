package milestone2_observer;

public class CustomerNotifier implements Observer {
    OrderStatusPublisher publisher;

    public CustomerNotifier(OrderStatusPublisher publisher) {
        this.publisher = publisher;
        publisher.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Customer Notifier: Your order " + publisher.getOrderId() + " is now " + publisher.getOrderStatus());
    }
}