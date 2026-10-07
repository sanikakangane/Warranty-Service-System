import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WarrantyManagementGUI gui = new WarrantyManagementGUI();
            gui.setVisible(true);
        });
    }
}