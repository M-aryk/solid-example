package product;

public class Furniture extends Product {
    private boolean requiredInstallation;

    // OCP добавлен новый конструктор:

    public Furniture(String productName, int price, String manufacturer, double rating, boolean requiredInstallation) {
        super(productName, price, manufacturer, rating);
        this.requiredInstallation = requiredInstallation;
    }

    public boolean isRequiredInstallation() {
        return requiredInstallation;
    }

    public void setRequiredInstallation(boolean requiredInstallation) {
        this.requiredInstallation = requiredInstallation;
    }
}
