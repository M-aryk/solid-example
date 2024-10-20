package product;

public abstract class Product {
    protected String productName;
    protected int price;
    protected String manufacturer;
    protected double rating;

    public Product(String productName, int price, String manufacturer, double rating) {
        this.productName = productName;
        this.price = price;
        this.manufacturer = manufacturer;
        this.rating = rating;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getRating() {
        return rating;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return
                "Товар: " + productName +
                        ", цена: " + price +
                        ", производитель: " + manufacturer +
                        ", рейтинг: " + rating;
    }
}
