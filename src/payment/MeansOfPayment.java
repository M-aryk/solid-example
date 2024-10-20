package payment;

import order.Order;

public interface MeansOfPayment {

    void pay(Order order);
}
