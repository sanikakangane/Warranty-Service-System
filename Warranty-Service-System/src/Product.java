import java.time.LocalDate;

public abstract class Product {
    private String productId;
    private String name;
    private String serialNumber;
    private LocalDate purchaseDate;
    private String customerName;

    public Product(String productId, String name, String serialNumber, LocalDate purchaseDate, String customerName) {
        this.productId = productId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.customerName = customerName;
    }

    public abstract int warrantyPeriodMonths();

    public LocalDate getWarrantyExpiryDate() {
        return purchaseDate.plusMonths(warrantyPeriodMonths());
    }

    public boolean isWarrantyExpired() {
        return LocalDate.now().isAfter(getWarrantyExpiryDate());
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCategory() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return productId + " - " + name + " (" + getCategory() + ")";
    }
}