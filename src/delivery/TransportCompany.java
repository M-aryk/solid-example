package delivery;

import order.Order;
import order.OrderStatus;

import java.util.Objects;

public class TransportCompany implements Sending, Getting {

    @Override
    public void send(Order order, String address) {
        if (Objects.requireNonNull(order.getOrderStatus()).equals(OrderStatus.PAY)) {
            order.setOrderStatus(OrderStatus.SEND);
            System.out.println("Заказ передан транспортной компании для дальнейшей доставки\n");
        } else {
            System.out.println("Заказ не готов к отправке. Оплатите заказ");
        }
    }

    @Override
    public void get(Order order) {
        if (Objects.requireNonNull(order.getOrderStatus()).equals(OrderStatus.SEND)) {
            order.setOrderStatus(OrderStatus.GET);
            System.out.println("Заказ получен");

        }
    }
}
