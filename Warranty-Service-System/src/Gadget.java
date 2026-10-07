import java.time.LocalDate;

public class Gadget extends Product {
    public Gadget(String productId, String name, String serialNumber, LocalDate purchaseDate, String customerName) {
        super(productId, name, serialNumber, purchaseDate, customerName);
    }

    @Override
    public int warrantyPeriodMonths() {
        return 12;
    }
}