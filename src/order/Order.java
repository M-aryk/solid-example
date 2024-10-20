package order;

import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int count;
    private int orderNumber;
    private List<Product> purchase = new ArrayList<>();
    private int amount;
    private OrderStatus orderStatus;

    public Order() {
    }

    public void createOrder(ShoppingBasket shoppingBasket) {
        if (shoppingBasket == null) {
            System.out.println("Корзина пустаю Выберите товар");
        }
        this.purchase = shoppingBasket.getPurchase();
        this.amount = shoppingBasket.getAmount();
        this.orderStatus = OrderStatus.CREATE;
        count++;
        orderNumber = count;
        shoppingBasket = null;
        System.out.printf("Заказ № %d создан и ожидает оплаты\n", orderNumber);
    }

    public int getOrderNumber() {
        return orderNumber;
    }


    public List<Product> getPurchase() {
        return purchase;
    }


    public int getAmount() {
        return amount;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String orderStatus() {
        String stat = switch (orderStatus) {
            case CREATE -> "Заказ № " + orderNumber + " создан\n";
            case PAY -> "Заказ № " + orderNumber + " оплачен\n";
            case SEND -> "Заказ № " + orderNumber + " отправлен\n";
            case READY_TO_GET -> "Заказ № " + orderNumber + " готов к получению\n";
            case GET -> "Заказ № " + orderNumber + " получен покупателем\n";
        };
        return stat;
    }

    @Override
    public String toString() {
        return "Заказ № " + orderNumber +
                ", статус заказа" + orderStatus + "\n";
    }
}
