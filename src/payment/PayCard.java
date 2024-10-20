package payment;

import order.Order;
import order.OrderStatus;

import java.util.Objects;

public class PayCard implements MeansOfPayment {

    @Override
    public void pay(Order order) {
        if (order.getOrderStatus() == null) {
            System.out.println("Заказ еще не создан");
        } else if (Objects.requireNonNull(order.getOrderStatus()).equals(OrderStatus.CREATE)) {
            order.setOrderStatus(OrderStatus.PAY);
            System.out.println("Оплата прошла успешно");
        } else {
            System.out.println("Недостаточно денежных средств. Воспользуйтесь другим средством платежа.");
        }
    }
}
