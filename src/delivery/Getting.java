package delivery;

import order.Order;

// ISP за отправку и получение ответственны 2 класса, т.к. например, при самовывозе отправки нет
public interface Getting {
    void get(Order order);
}
