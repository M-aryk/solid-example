package delivery;

import order.Order;
import order.OrderStatus;

import java.util.Objects;

public class SelfDelivery implements Getting {
    public void ready(Order order) {
        if (Objects.requireNonNull(order.getOrderStatus()).equals(OrderStatus.PAY)) {
            order.setOrderStatus(OrderStatus.READY_TO_GET);
            System.out.println("Заказ готов к выдаче");
        } else {
            System.out.println("Заказ не готов к выдаче. Оплатите заказ");
        }
    }

    @Override
    public void get(Order order) {
        if (Objects.requireNonNull(order.getOrderStatus()).equals(OrderStatus.READY_TO_GET)) {
            order.setOrderStatus(OrderStatus.GET);
            System.out.println("Заказ получен");

        }
    }
}
