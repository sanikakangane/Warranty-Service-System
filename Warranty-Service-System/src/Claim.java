import java.time.LocalDate;

public class Claim {
    private String claimId;
    private Product product;
    private String issueDescription;
    private LocalDate claimDate;
    private LocalDate repairAppointmentDate;
    private ClaimStatus status;

    public Claim(String claimId, Product product, String issueDescription, LocalDate claimDate) {
        this.claimId = claimId;
        this.product = product;
        this.issueDescription = issueDescription;
        this.claimDate = claimDate;
        this.status = ClaimStatus.FILED;
    }

    public void scheduleRepair(LocalDate appointmentDate) {
        this.repairAppointmentDate = appointmentDate;
        this.status = ClaimStatus.REPAIR_SCHEDULED;
    }

    public String getClaimId() {
        return claimId;
    }

    public Product getProduct() {
        return product;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public LocalDate getRepairAppointmentDate() {
        return repairAppointmentDate;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        String appointment = repairAppointmentDate == null ? "Not scheduled" : repairAppointmentDate.toString();
        return claimId + " | " + product.getName() + " | " + claimDate + " | " + status + " | Repair: " + appointment;
    }
}