import java.time.LocalDate;

public class Electronics extends Product {
    public Electronics(String productId, String name, String serialNumber, LocalDate purchaseDate, String customerName) {
        super(productId, name, serialNumber, purchaseDate, customerName);
    }

    @Override
    public int warrantyPeriodMonths() {
        return 24;
    }
}