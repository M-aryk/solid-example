package payment;

import order.OrderStatus;
import order.Order;

import java.util.Objects;

public class GiftCard implements MeansOfPayment {
    private int balance = 200000;

    public GiftCard() {
    }

    public boolean possiblePay(Order order) {
        if (order.getAmount() > balance) {
            return false;
        } else {
            balance -= order.getAmount();
        }
        return true;
    }

    @Override
    public void pay(Order order) {
        if (order.getOrderStatus() == null) {
            System.out.println("Заказ еще не создан");
        } else if (possiblePay(order) && Objects.requireNonNull(order.getOrderStatus()).equals(OrderStatus.CREATE)) {
            order.setOrderStatus(OrderStatus.PAY);
            System.out.println("Оплата прошла успешно");
        } else {
            System.out.println("Недостаточно денежных средств. Воспользуйтесь другим средством платежа.");
        }
    }

    public int getBalance() {
        return balance;
    }

}

