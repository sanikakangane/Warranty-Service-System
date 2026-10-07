import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ServiceCenter {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Claim> claims = new ArrayList<>();
    private LinkedList<String> claimHistory = new LinkedList<>();
    private HashMap<String, Warranty> warrantyByProductId = new HashMap<>();
    private TreeMap<LocalDate, ArrayList<Claim>> claimsByDate = new TreeMap<>();

    public void registerProduct(Product product) {
        products.add(product);
        warrantyByProductId.put(product.getProductId(), new Warranty(product));
    }

    public Claim fileClaim(String claimId, String productId, String issueDescription)
            throws ExpiredWarrantyException {
        Product product = findProductById(productId);

        if (product == null) {
            throw new IllegalArgumentException("Product ID not found.");
        }

        if (product.isWarrantyExpired()) {
            throw new ExpiredWarrantyException("Warranty expired on " + product.getWarrantyExpiryDate());
        }

        Claim claim = new Claim(claimId, product, issueDescription, LocalDate.now());
        claims.add(claim);
        claimHistory.add("Claim " + claimId + " filed for product " + productId);

        claimsByDate.putIfAbsent(claim.getClaimDate(), new ArrayList<>());
        claimsByDate.get(claim.getClaimDate()).add(claim);

        return claim;
    }

    public void scheduleRepair(String claimId, LocalDate appointmentDate) {
        Claim claim = findClaimById(claimId);

        if (claim == null) {
            throw new IllegalArgumentException("Claim ID not found.");
        }

        if (appointmentDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Repair date cannot be in the past.");
        }

        claim.scheduleRepair(appointmentDate);
        claimHistory.add("Repair scheduled for claim " + claimId + " on " + appointmentDate);
    }

    public Product findProductById(String productId) {
        for (Product product : products) {
            if (product.getProductId().equalsIgnoreCase(productId)) {
                return product;
            }
        }
        return null;
    }

    public Claim findClaimById(String claimId) {
        for (Claim claim : claims) {
            if (claim.getClaimId().equalsIgnoreCase(claimId)) {
                return claim;
            }
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public List<Product> getProductsSortedByWarrantyExpiry() {
        ArrayList<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort(Comparator.comparing(Product::getWarrantyExpiryDate));
        return sortedProducts;
    }

    public List<Claim> searchClaims(String keyword) {
        ArrayList<Claim> results = new ArrayList<>();
        String smallKeyword = keyword.toLowerCase();

        for (Claim claim : claims) {
            boolean claimMatches = claim.getClaimId().toLowerCase().contains(smallKeyword);
            boolean productMatches = claim.getProduct().getProductId().toLowerCase().contains(smallKeyword);
            boolean issueMatches = claim.getIssueDescription().toLowerCase().contains(smallKeyword);

            if (claimMatches || productMatches || issueMatches) {
                results.add(claim);
            }
        }

        return results;
    }

    public String buildReport() {
        StringBuilder report = new StringBuilder();
        report.append("SERVICE REPORT\n\n");
        report.append("Total products: ").append(products.size()).append("\n");
        report.append("Total claims: ").append(claims.size()).append("\n\n");

        report.append("Warranty Details:\n");
        for (Map.Entry<String, Warranty> entry : warrantyByProductId.entrySet()) {
            report.append("- ").append(entry.getValue()).append("\n");
        }

        report.append("\nClaims Sorted By Date:\n");
        for (Map.Entry<LocalDate, ArrayList<Claim>> entry : claimsByDate.entrySet()) {
            report.append(entry.getKey()).append(":\n");
            for (Claim claim : entry.getValue()) {
                report.append("  - ").append(claim).append("\n");
            }
        }

        report.append("\nClaim History:\n");
        for (String historyLine : claimHistory) {
            report.append("- ").append(historyLine).append("\n");
        }

        return report.toString();
    }
}