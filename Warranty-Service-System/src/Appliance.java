import java.time.LocalDate;

public class Appliance extends Product {
    public Appliance(String productId, String name, String serialNumber, LocalDate purchaseDate, String customerName) {
        super(productId, name, serialNumber, purchaseDate, customerName);
    }

    @Override
    public int warrantyPeriodMonths() {
        return 36;
    }
}