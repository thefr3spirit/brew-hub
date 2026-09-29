package milestone2_observer;

public class KitchenDisplay implements Observer {
    OrderStatusPublisher publisher;

    public KitchenDisplay(OrderStatusPublisher publisher) {
        this.publisher = publisher;
        publisher.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Kitchen Display: Order " + publisher.getOrderId() + " is now " + publisher.getOrderStatus());
    }
}