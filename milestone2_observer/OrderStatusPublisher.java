package milestone2_observer;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusPublisher implements Subject {
    private List<Observer> observers;
    private String orderStatus, orderId;
    private double orderAmount;

    public OrderStatusPublisher() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }       

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setOrderStatus(String orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        
        notifyObservers();
    }

    public void setOrderStatus(String orderId, String orderStatus, double orderAmount) {
       
        this.orderAmount = orderAmount;
        setOrderStatus(orderId, orderStatus); //reusing the old method.
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}