import delivery.*;
import order.*;
import payment.GiftCard;
import payment.PayCard;
import person.Buyer;
import product.Furniture;
import product.Product;
import product.SportsProducts;
import rating.RatingProducts;
import rating.RatingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Buyer buyer = new Buyer();
        Product findingProduct = null;
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        Order order = new Order();
        RatingService rating = new RatingProducts();

        List<Product> products = new ArrayList<>();
        Product sport1 = new SportsProducts("Тренажер эллиптический", 55000, "СпортИнвентарь", 0);
        Product furniture1 = new Furniture("Шведская стенка", 25000, "Мануфактура", 0, true);
        Product furniture2 = new Furniture("Диван Соло", 30000, "Manufacture", 0, false);
        products.add(sport1);
        products.add(furniture1);
        products.add(furniture2);

        System.out.println("Добрый день! Вас приветствует интернет-магазин \"Товары на дом\"");
        System.out.println("Чтобы сделать заказ, введите свои данные");
        createNewBuyer(scanner, buyer);

        showMenu();

        boolean isContinue = true;

        while (isContinue) {
            String operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    System.out.println("Предлагаем следующие виды товаров: ");
                    printProducts(products);
                    findingProduct = findProduct(scanner, products);
                    showMenu();
                    break;
                case "2":
                    System.out.print("Введите количество товара: ");
                    shoppingBasket.addInBasket(findingProduct, Integer.parseInt(scanner.nextLine()));
                    showMenu();
                    break;
                case "3":
                    order.createOrder(shoppingBasket);
                    buyer.getMeansOfPayment().pay(order);
                    choiceDelivery(scanner, order, buyer);
                    gettingOrder(scanner, order);
                    showMenu();
                    break;
                case "4":
                    ratingProduct(scanner, products, rating);
                    showMenu();
                    break;
                case "5":
                    System.out.println("Программа завершена");
                    isContinue = false;
                    break;
            }
        }
    }

    private static void ratingProduct(Scanner scanner, List<Product> products, RatingService rating) {
        Product toRate;
        System.out.println("Оцените товар");
        toRate = findProduct(scanner, products);
        System.out.println("Поставьте оценку от 0 до 5");
        toRate.setRating(rating.calcRating(Integer.parseInt(scanner.nextLine()), toRate.getRating()));
    }

    private static void gettingOrder(Scanner scanner, Order order) {
        System.out.println("Вы получили заказ (y / n)?");
        String getting = scanner.nextLine();
        switch (getting) {
            case "y":
                order.setOrderStatus(OrderStatus.GET);
                break;
            case "n":
                System.out.println("Ожидается получение");
                break;
        }
    }

    private static void choiceDelivery(Scanner scanner, Order order, Buyer buyer) {
        System.out.println("Как доставить заказ:\n" +
                "1. Курьером\n" +
                "2. Транспортной компанией\n" +
                "3. Самовывоз");
        String delivering = scanner.nextLine();
        switch (delivering) {
            case "1":
                Sending courier = new Courier();
                courier.send(order, buyer.getAddress());
                break;
            case "2":
                Sending transportCompany = new TransportCompany();
                transportCompany.send(order, buyer.getAddress());
                break;
            case "3":
                SelfDelivery selfDelivery = new SelfDelivery();
                selfDelivery.ready(order);
                break;
        }
    }

    private static void createNewBuyer(Scanner scanner, Buyer buyer) {
        System.out.print("Введите имя: ");
        buyer.setName(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        buyer.setSurname(scanner.nextLine());
        System.out.print("Введите адрес: ");
        buyer.setAddress(scanner.nextLine());
        System.out.println("Выберите средство платежа:\n" +
                "1. Подарочная карта\n" +
                "2. Платежная карта");
        String meansOfPayment = scanner.nextLine();
        switch (meansOfPayment) {
            case "1":
                GiftCard giftCard = new GiftCard();
                buyer.setMeansOfPayment(giftCard);
                break;
            case "2":
                PayCard payCard = new PayCard();
                buyer.setMeansOfPayment(payCard);
                break;
        }
    }

    private static void showMenu() {
        System.out.println("Выберите операцию:\n" +
                "1. Выбор товара\n" +
                "2. Добавление товара в корзину\n" +
                "3. Создание заказа\n" +
                "4. Оценка товара\n" +
                "5. Выйти из программы");
    }

    //dry - метод вызывается дважды: выбор товара для заказа и для проставления рейтинга:
    private static Product findProduct(Scanner scanner, List<Product> products) {
        Product find = null;
        System.out.println("Выберите товар\nДоступные фильтры:\n" +
                "1. По ключевому слову\n" +
                "2. По цене\n" +
                "3. По производителю");

        String filter = scanner.nextLine();
        switch (filter) {
            case "1":
                System.out.print("Введитe слово: ");
                find = findByWord(scanner.nextLine(), products);
                System.out.println(find);
                break;
            case "2":
                System.out.print("Введитe цену: ");
                find = findByPrice(Integer.parseInt(scanner.nextLine()), products);
                System.out.println(find);
                break;
            case "3":
                System.out.print("Введитe наименование производителя: ");
                find = findByManufacturer(scanner.nextLine(), products);
                System.out.println(find);
                break;
        }
        return find;
    }

    private static Product findByManufacturer(String findManufacturer, List<Product> products) {
        Product finding;
        List<Product> find = products.stream()
                .filter(product -> product.getManufacturer().contains(findManufacturer))
                .toList();
        finding = find.getFirst();
        return finding;
    }

    private static Product findByPrice(int findPrice, List<Product> products) {
        Product finding;
        List<Product> find = products.stream()
                .filter(product -> product.getPrice() == findPrice)
                .toList();
        finding = find.getFirst();
        return finding;
    }

    private static Product findByWord(String findword, List<Product> products) {
        Product finding;
        List<Product> find = products.stream()
                .filter(product -> product.getProductName().contains(findword))
                .toList();
        finding = find.getFirst();
        return finding;
    }

    private static void printProducts(List<Product> products) {
        int i = 0;
        // магические числа:
        while (i < products.size()) {
            System.out.println(products.get(i));
            i++;
        }
    }
}
