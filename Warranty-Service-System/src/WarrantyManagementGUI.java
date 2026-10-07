import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class WarrantyManagementGUI extends JFrame {

    private ServiceCenter serviceCenter = new ServiceCenter();

    private JTextArea outputArea = new JTextArea();

    private JTextField productIdField = new JTextField();
    private JTextField productNameField = new JTextField();
    private JTextField serialNumberField = new JTextField();
    private JTextField purchaseDateField = new JTextField("2026-01-01");
    private JTextField customerNameField = new JTextField();

    private JComboBox<String> categoryBox =
            new JComboBox<>(new String[]{
                    "Electronics",
                    "Appliance",
                    "Gadget"
            });

    private JTextField claimIdField = new JTextField();
    private JTextField claimProductIdField = new JTextField();
    private JTextField issueField = new JTextField();

    private JTextField repairClaimIdField = new JTextField();
    private JTextField repairDateField = new JTextField("2026-10-20");

    private JTextField searchField = new JTextField();

    private final Color backgroundColor =
            new Color(245, 247, 250);

    private final Color cardColor =
            Color.WHITE;

    private final Color primaryColor =
            new Color(45, 85, 150);

    private final Color textColor =
            new Color(35, 40, 45);

    private final Color borderColor =
            new Color(220, 225, 230);

    public WarrantyManagementGUI() {

        setTitle("Warranty Ka Kya Scene Hai?");
        setSize(1150, 750);
        setMinimumSize(new Dimension(1000, 650));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception exception) {
        }

        getContentPane().setBackground(backgroundColor);

        setLayout(new BorderLayout(15, 15));

        add(buildHeader(), BorderLayout.NORTH);
        add(buildMainContent(), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);

        seedSampleData();
        showAllProducts();
    }

    private JPanel buildHeader() {

        JPanel header =
                new JPanel(new BorderLayout());

        header.setBackground(primaryColor);

        header.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        30,
                        20,
                        30
                )
        );

        JLabel title =
                new JLabel("Warranty Ka Kya Scene Hai?");

        title.setForeground(Color.WHITE);

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        28
                )
        );

        JLabel subtitle =
                new JLabel(
                        "Track It  •  Claim It  •  Repair It"
                );

        subtitle.setForeground(
                new Color(225, 235, 250)
        );

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14
                )
        );

        JPanel textPanel =
                new JPanel(
                        new GridLayout(2, 1, 0, 5)
                );

        textPanel.setOpaque(false);

        textPanel.add(title);
        textPanel.add(subtitle);

        header.add(
                textPanel,
                BorderLayout.WEST
        );

        JLabel status =
                new JLabel("●  SERVICE CENTER");

        status.setForeground(Color.WHITE);

        status.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        header.add(
                status,
                BorderLayout.EAST
        );

        return header;
    }

    private JPanel buildMainContent() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        mainPanel.setBackground(backgroundColor);

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        15,
                        0,
                        15
                )
        );

        JTabbedPane tabs =
                new JTabbedPane();

        tabs.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        tabs.addTab(
                "Product & Warranty",
                buildProductTab()
        );

        tabs.addTab(
                "Claims & Repair",
                buildClaimTab()
        );

        tabs.addTab(
                "Search & Reports",
                buildActionTab()
        );

        mainPanel.add(
                tabs,
                BorderLayout.NORTH
        );

        outputArea.setEditable(false);

        outputArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14
                )
        );

        outputArea.setForeground(textColor);

        outputArea.setBackground(Color.WHITE);

        outputArea.setLineWrap(true);

        outputArea.setWrapStyleWord(true);

        outputArea.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(outputArea);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                borderColor
                        ),
                        "System Output"
                )
        );

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        return mainPanel;
    }

    private JPanel buildProductTab() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        mainPanel.setBackground(backgroundColor);

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        JPanel formPanel =
                createCardPanel();

        formPanel.setLayout(
                new GridBagLayout()
        );

        addFormField(
                formPanel,
                "Product ID",
                productIdField,
                0
        );

        addFormField(
                formPanel,
                "Product Name",
                productNameField,
                1
        );

        addFormField(
                formPanel,
                "Serial Number",
                serialNumberField,
                2
        );

        addFormField(
                formPanel,
                "Purchase Date",
                purchaseDateField,
                3
        );

        addFormField(
                formPanel,
                "Customer Name",
                customerNameField,
                4
        );

        addFormField(
                formPanel,
                "Category",
                categoryBox,
                5
        );

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        buttonPanel.setOpaque(false);

        JButton clearButton =
                createSecondaryButton("Clear");

        clearButton.addActionListener(
                event -> clearProductFields()
        );

        JButton registerButton =
                createPrimaryButton(
                        "Register Product"
                );

        registerButton.addActionListener(
                event -> registerProduct()
        );

        buttonPanel.add(clearButton);
        buttonPanel.add(registerButton);

        mainPanel.add(
                formPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        return mainPanel;
    }

    private JPanel buildClaimTab() {

        JPanel mainPanel =
                new JPanel(
                        new GridLayout(1, 2, 15, 0)
                );

        mainPanel.setBackground(
                backgroundColor
        );

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        JPanel claimPanel =
                createCardPanel();

        claimPanel.setLayout(
                new GridBagLayout()
        );

        addFormField(
                claimPanel,
                "Claim ID",
                claimIdField,
                0
        );

        addFormField(
                claimPanel,
                "Product ID",
                claimProductIdField,
                1
        );

        addFormField(
                claimPanel,
                "Issue Details",
                issueField,
                2
        );

        JButton claimButton =
                createPrimaryButton(
                        "File Claim"
                );

        claimButton.addActionListener(
                event -> fileClaim()
        );

        JPanel claimButtonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        claimButtonPanel.setOpaque(false);

        claimButtonPanel.add(claimButton);

        GridBagConstraints claimConstraints =
                new GridBagConstraints();

        claimConstraints.gridx = 0;
        claimConstraints.gridy = 3;

        claimConstraints.gridwidth = 2;

        claimConstraints.weightx = 1;

        claimConstraints.fill =
                GridBagConstraints.HORIZONTAL;

        claimConstraints.insets =
                new Insets(
                        15,
                        10,
                        10,
                        10
                );

        claimPanel.add(
                claimButtonPanel,
                claimConstraints
        );

        JPanel repairPanel =
                createCardPanel();

        repairPanel.setLayout(
                new GridBagLayout()
        );

        addFormField(
                repairPanel,
                "Claim ID",
                repairClaimIdField,
                0
        );

        addFormField(
                repairPanel,
                "Repair Date",
                repairDateField,
                1
        );

        JButton repairButton =
                createPrimaryButton(
                        "Schedule Repair"
                );

        repairButton.addActionListener(
                event -> scheduleRepair()
        );

        JPanel repairButtonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        repairButtonPanel.setOpaque(false);

        repairButtonPanel.add(repairButton);

        GridBagConstraints repairConstraints =
                new GridBagConstraints();

        repairConstraints.gridx = 0;
        repairConstraints.gridy = 2;

        repairConstraints.gridwidth = 2;

        repairConstraints.weightx = 1;

        repairConstraints.fill =
                GridBagConstraints.HORIZONTAL;

        repairConstraints.insets =
                new Insets(
                        15,
                        10,
                        10,
                        10
                );

        repairPanel.add(
                repairButtonPanel,
                repairConstraints
        );

        JPanel leftPanel =
                new JPanel(
                        new BorderLayout()
                );

        leftPanel.setOpaque(false);

        leftPanel.add(
                createSectionTitle(
                        "Service Claim"
                ),
                BorderLayout.NORTH
        );

        leftPanel.add(
                claimPanel,
                BorderLayout.CENTER
        );

        JPanel rightPanel =
                new JPanel(
                        new BorderLayout()
                );

        rightPanel.setOpaque(false);

        rightPanel.add(
                createSectionTitle(
                        "Repair Scheduling"
                ),
                BorderLayout.NORTH
        );

        rightPanel.add(
                repairPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        return mainPanel;
    }

    private JPanel buildActionTab() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        mainPanel.setBackground(
                backgroundColor
        );

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        JPanel searchPanel =
                createCardPanel();

        searchPanel.setLayout(
                new BorderLayout(
                        15,
                        10
                )
        );

        JLabel searchLabel =
                new JLabel(
                        "Search claims by product ID, claim ID or issue"
                );

        searchLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        searchLabel.setForeground(textColor);

        JPanel searchInputPanel =
                new JPanel(
                        new BorderLayout(10, 0)
                );

        searchInputPanel.setOpaque(false);

        searchInputPanel.add(
                searchField,
                BorderLayout.CENTER
        );

        JButton searchButton =
                createPrimaryButton(
                        "Search Claims"
                );

        searchButton.addActionListener(
                event -> searchClaims()
        );

        searchInputPanel.add(
                searchButton,
                BorderLayout.EAST
        );

        searchPanel.add(
                searchLabel,
                BorderLayout.NORTH
        );

        searchPanel.add(
                searchInputPanel,
                BorderLayout.CENTER
        );

        JPanel buttonsPanel =
                createCardPanel();

        buttonsPanel.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        15,
                        15
                )
        );

        JButton productsButton =
                createSecondaryButton(
                        "View Products"
                );

        productsButton.addActionListener(
                event -> showAllProducts()
        );

        JButton claimsButton =
                createSecondaryButton(
                        "View Claims"
                );

        claimsButton.addActionListener(
                event -> showAllClaims()
        );

        JButton expiryButton =
                createSecondaryButton(
                        "Sort By Expiry"
                );

        expiryButton.addActionListener(
                event -> showProductsSortedByExpiry()
        );

        JButton reportButton =
                createPrimaryButton(
                        "Generate Report"
                );

        reportButton.addActionListener(
                event ->
                        outputArea.setText(
                                serviceCenter.buildReport()
                        )
        );

        buttonsPanel.add(productsButton);
        buttonsPanel.add(claimsButton);
        buttonsPanel.add(expiryButton);
        buttonsPanel.add(reportButton);

        mainPanel.add(
                searchPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                buttonsPanel,
                BorderLayout.CENTER
        );

        return mainPanel;
    }

    private JPanel createCardPanel() {

        JPanel panel =
                new JPanel();

        panel.setBackground(cardColor);

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                borderColor
                        ),
                        BorderFactory.createEmptyBorder(
                                15,
                                15,
                                15,
                                15
                        )
                )
        );

        return panel;
    }

    private JLabel createSectionTitle(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        17
                )
        );

        label.setForeground(
                primaryColor
        );

        label.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        5,
                        8,
                        0
                )
        );

        return label;
    }

    private void addFormField(
            JPanel panel,
            String labelText,
            java.awt.Component component,
            int row
    ) {

        GridBagConstraints labelConstraints =
                new GridBagConstraints();

        labelConstraints.gridx = 0;
        labelConstraints.gridy = row;

        labelConstraints.weightx = 0.25;

        labelConstraints.fill =
                GridBagConstraints.HORIZONTAL;

        labelConstraints.insets =
                new Insets(
                        8,
                        8,
                        8,
                        12
                );

        JLabel label =
                new JLabel(labelText);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        label.setForeground(textColor);

        panel.add(
                label,
                labelConstraints
        );

        GridBagConstraints fieldConstraints =
                new GridBagConstraints();

        fieldConstraints.gridx = 1;
        fieldConstraints.gridy = row;

        fieldConstraints.weightx = 1;

        fieldConstraints.fill =
                GridBagConstraints.HORIZONTAL;

        fieldConstraints.insets =
                new Insets(
                        8,
                        8,
                        8,
                        8
                );

        component.setPreferredSize(
                new Dimension(
                        200,
                        35
                )
        );

        panel.add(
                component,
                fieldConstraints
        );
    }

    private JButton createPrimaryButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(
                primaryColor
        );

        button.setBackground(
                Color.WHITE
        );

        button.setOpaque(true);

        button.setContentAreaFilled(true);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                primaryColor
                        ),
                        BorderFactory.createEmptyBorder(
                                8,
                                15,
                                8,
                                15
                        )
                )
        );

        button.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    private JButton createSecondaryButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(
                primaryColor
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                primaryColor
                        ),
                        BorderFactory.createEmptyBorder(
                                8,
                                15,
                                8,
                                15
                        )
                )
        );

        button.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    private JPanel buildFooter() {

        JPanel footer =
                new JPanel(
                        new BorderLayout()
                );

        footer.setBackground(
                new Color(
                        235,
                        238,
                        242
                )
        );

        footer.setBorder(
                BorderFactory.createEmptyBorder(
                        8,
                        15,
                        8,
                        15
                )
        );

        JLabel left =
                new JLabel(
                        "Warranty Management System"
                );

        left.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        left.setForeground(
                new Color(
                        90,
                        95,
                        100
                )
        );

        JLabel right =
                new JLabel(
                        "Java Programming • Semester III"
                );

        right.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        right.setForeground(
                new Color(
                        90,
                        95,
                        100
                )
        );

        right.setHorizontalAlignment(
                SwingConstants.RIGHT
        );

        footer.add(
                left,
                BorderLayout.WEST
        );

        footer.add(
                right,
                BorderLayout.EAST
        );

        return footer;
    }

    private void registerProduct() {

        try {

            validateTextField(
                    productIdField,
                    "Product ID"
            );

            validateTextField(
                    productNameField,
                    "Product name"
            );

            validateTextField(
                    serialNumberField,
                    "Serial number"
            );

            validateTextField(
                    customerNameField,
                    "Customer name"
            );

            String category =
                    (String)
                            categoryBox.getSelectedItem();

            LocalDate purchaseDate =
                    LocalDate.parse(
                            purchaseDateField
                                    .getText()
                                    .trim()
                    );

            Product product;

            if ("Electronics".equals(category)) {

                product =
                        new Electronics(
                                productIdField
                                        .getText()
                                        .trim(),

                                productNameField
                                        .getText()
                                        .trim(),

                                serialNumberField
                                        .getText()
                                        .trim(),

                                purchaseDate,

                                customerNameField
                                        .getText()
                                        .trim()
                        );

            } else if ("Appliance".equals(category)) {

                product =
                        new Appliance(
                                productIdField
                                        .getText()
                                        .trim(),

                                productNameField
                                        .getText()
                                        .trim(),

                                serialNumberField
                                        .getText()
                                        .trim(),

                                purchaseDate,

                                customerNameField
                                        .getText()
                                        .trim()
                        );

            } else {

                product =
                        new Gadget(
                                productIdField
                                        .getText()
                                        .trim(),

                                productNameField
                                        .getText()
                                        .trim(),

                                serialNumberField
                                        .getText()
                                        .trim(),

                                purchaseDate,

                                customerNameField
                                        .getText()
                                        .trim()
                        );
            }

            serviceCenter.registerProduct(
                    product
            );

            showMessage(
                    "Product registered successfully."
            );

            clearProductFields();

            showAllProducts();

        } catch (
                DateTimeParseException exception
        ) {

            showMessage(
                    "Use date format YYYY-MM-DD."
            );

        } catch (
                IllegalArgumentException exception
        ) {

            showMessage(
                    exception.getMessage()
            );
        }
    }

    private void fileClaim() {

        try {

            validateTextField(
                    claimIdField,
                    "Claim ID"
            );

            validateTextField(
                    claimProductIdField,
                    "Product ID"
            );

            validateTextField(
                    issueField,
                    "Issue details"
            );

            serviceCenter.fileClaim(
                    claimIdField
                            .getText()
                            .trim(),

                    claimProductIdField
                            .getText()
                            .trim(),

                    issueField
                            .getText()
                            .trim()
            );

            showMessage(
                    "Claim filed successfully."
            );

            clearClaimFields();

            showAllClaims();

        } catch (
                ExpiredWarrantyException |
                IllegalArgumentException exception
        ) {

            showMessage(
                    exception.getMessage()
            );
        }
    }

    private void scheduleRepair() {

        try {

            validateTextField(
                    repairClaimIdField,
                    "Repair claim ID"
            );

            LocalDate repairDate =
                    LocalDate.parse(
                            repairDateField
                                    .getText()
                                    .trim()
                    );

            serviceCenter.scheduleRepair(
                    repairClaimIdField
                            .getText()
                            .trim(),

                    repairDate
            );

            showMessage(
                    "Repair scheduled successfully."
            );

            clearRepairFields();

            showAllClaims();

        } catch (
                DateTimeParseException exception
        ) {

            showMessage(
                    "Use date format YYYY-MM-DD."
            );

        } catch (
                IllegalArgumentException exception
        ) {

            showMessage(
                    exception.getMessage()
            );
        }
    }

    private void searchClaims() {

        List<Claim> results =
                serviceCenter.searchClaims(
                        searchField
                                .getText()
                                .trim()
                );

        StringBuilder text =
                new StringBuilder(
                        "SEARCH RESULTS\n"
                );

        text.append(
                "========================================\n\n"
        );

        for (Claim claim : results) {

            text.append(
                    claim
            );

            text.append("\n");
        }

        if (results.isEmpty()) {

            text.append(
                    "No matching claims found."
            );
        }

        outputArea.setText(
                text.toString()
        );

        outputArea.setCaretPosition(0);
    }

    private void showAllProducts() {

        StringBuilder text =
                new StringBuilder(
                        "REGISTERED PRODUCTS\n"
                );

        text.append(
                "========================================\n\n"
        );

        for (
                Product product :
                serviceCenter.getProducts()
        ) {

            text.append(
                    product
            );

            text.append("\n");

            text.append(
                    "Customer: "
            );

            text.append(
                    product.getCustomerName()
            );

            text.append("\n");

            text.append(
                    "Serial: "
            );

            text.append(
                    product.getSerialNumber()
            );

            text.append("\n");

            text.append(
                    "Purchase Date: "
            );

            text.append(
                    product.getPurchaseDate()
            );

            text.append("\n");

            text.append(
                    "Warranty Expires: "
            );

            text.append(
                    product.getWarrantyExpiryDate()
            );

            text.append("\n");

            text.append(
                    "Status: "
            );

            text.append(
                    product.isWarrantyExpired()
                            ? "EXPIRED"
                            : "ACTIVE"
            );

            text.append("\n");

            text.append(
                    "----------------------------------------\n"
            );
        }

        outputArea.setText(
                text.toString()
        );

        outputArea.setCaretPosition(0);
    }

    private void showAllClaims() {

        StringBuilder text =
                new StringBuilder(
                        "SERVICE CLAIMS\n"
                );

        text.append(
                "========================================\n\n"
        );

        for (
                Claim claim :
                serviceCenter.getClaims()
        ) {

            text.append(
                    claim
            );

            text.append("\n");

            text.append(
                    "Issue: "
            );

            text.append(
                    claim.getIssueDescription()
            );

            text.append("\n");

            text.append(
                    "----------------------------------------\n"
            );
        }

        outputArea.setText(
                text.toString()
        );

        outputArea.setCaretPosition(0);
    }

    private void showProductsSortedByExpiry() {

        StringBuilder text =
                new StringBuilder(
                        "PRODUCTS SORTED BY WARRANTY EXPIRY\n"
                );

        text.append(
                "========================================\n\n"
        );

        for (
                Product product :
                serviceCenter
                        .getProductsSortedByWarrantyExpiry()
        ) {

            text.append(
                    product.getProductId()
            );

            text.append(
                    "  |  "
            );

            text.append(
                    product.getName()
            );

            text.append(
                    "  |  Expires: "
            );

            text.append(
                    product.getWarrantyExpiryDate()
            );

            text.append("\n");
        }

        outputArea.setText(
                text.toString()
        );

        outputArea.setCaretPosition(0);
    }

    private void validateTextField(
            JTextField field,
            String fieldName
    ) {

        if (
                field.getText()
                        .trim()
                        .isEmpty()
        ) {

            throw new IllegalArgumentException(
                    fieldName +
                            " cannot be empty."
            );
        }
    }

    private void showMessage(
            String message
    ) {

        JOptionPane.showMessageDialog(
                this,
                message,
                "Warranty Ka Kya Scene Hai?",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void clearProductFields() {

        productIdField.setText("");

        productNameField.setText("");

        serialNumberField.setText("");

        purchaseDateField.setText(
                "2026-01-01"
        );

        customerNameField.setText("");

        categoryBox.setSelectedIndex(0);
    }

    private void clearClaimFields() {

        claimIdField.setText("");

        claimProductIdField.setText("");

        issueField.setText("");
    }

    private void clearRepairFields() {

        repairClaimIdField.setText("");

        repairDateField.setText(
                "2026-10-20"
        );
    }

    private void seedSampleData() {

        serviceCenter.registerProduct(
                new Electronics(
                        "P101",
                        "Laptop",
                        "SN-LAP-101",
                        LocalDate.of(
                                2026,
                                1,
                                10
                        ),
                        "Aarav"
                )
        );

        serviceCenter.registerProduct(
                new Appliance(
                        "P102",
                        "Washing Machine",
                        "SN-WM-102",
                        LocalDate.of(
                                2025,
                                7,
                                15
                        ),
                        "Diya"
                )
        );

        serviceCenter.registerProduct(
                new Gadget(
                        "P103",
                        "Smart Watch",
                        "SN-SW-103",
                        LocalDate.of(
                                2024,
                                8,
                                1
                        ),
                        "Kabir"
                )
        );
    }

    public static void main(
            String[] args
    ) {

        javax.swing.SwingUtilities.invokeLater(
                () -> {

                    WarrantyManagementGUI gui =
                            new WarrantyManagementGUI();

                    gui.setVisible(true);
                }
        );
    }
}