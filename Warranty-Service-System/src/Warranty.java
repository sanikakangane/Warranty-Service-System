import java.time.LocalDate;

public class Warranty {
    private String productId;
    private int warrantyMonths;
    private LocalDate startDate;
    private LocalDate expiryDate;

    public Warranty(Product product) {
        this.productId = product.getProductId();
        this.warrantyMonths = product.warrantyPeriodMonths();
        this.startDate = product.getPurchaseDate();
        this.expiryDate = product.getWarrantyExpiryDate();
    }

    public String getProductId() {
        return productId;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public String toString() {
        String status = isExpired() ? "Expired" : "Active";
        return productId + " | " + warrantyMonths + " months | expires " + expiryDate + " | " + status;
    }
}