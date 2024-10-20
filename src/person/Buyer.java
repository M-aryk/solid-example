package person;

import order.Order;
import payment.MeansOfPayment;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Person {
    private MeansOfPayment meansOfPayment;
    private List<Order> orders = new ArrayList<>();

    public Buyer() {
    }

    public Buyer(String name, String surname, String address, MeansOfPayment meansOfPayment) {
        super(name, surname, address);
        this.meansOfPayment = meansOfPayment;
    }

    public void addOrders(Order order) {
        orders.add(order);
    }

    public MeansOfPayment getMeansOfPayment() {
        return meansOfPayment;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setMeansOfPayment(MeansOfPayment meansOfPayment) {
        this.meansOfPayment = meansOfPayment;
    }


}
