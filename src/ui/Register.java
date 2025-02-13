
package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import dao.Constant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.DatabaseOperation;

public class Register extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField usernameField, phoneField, typeField;
    private JPasswordField passwordField;
    private JComboBox<String> cbType;
    
    public Register() {

        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(null);
        getContentPane().setBackground(new Color(0x2196F3));

        JPanel panel = createFormPanel();
        add(panel);

        setLocationRelativeTo(null); // Center window
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel();
        panel.setBounds(40, 50, 300, 350);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0x0057D9));
        titleLabel.setBounds(100, 10, 120, 30);
        panel.add(titleLabel);

        usernameField = createPlaceholderTextField("Enter your username", 50);
        panel.add(usernameField);

        phoneField = createPlaceholderTextField("Enter your phone number", 100);
        panel.add(phoneField);

        passwordField = createPlaceholderPasswordField("Enter your password", 150);
        panel.add(passwordField);
        
        JLabel userTypeLabel = new JLabel("Type:");
        userTypeLabel.setBounds(50, 200, 100, 30);
        panel.add(userTypeLabel);
        cbType = createPlaceholderComboBox(new String[]{"Nguoi lon","Tre em"}, 200);
        panel.add(cbType);

        JButton registerButton = new JButton("Confirm");
        registerButton.setBounds(90, 260, 120, 30);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(0x0057D9));
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(this::handleRegister);
        panel.add(registerButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(100, 300, 100, 25);
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(new Color(0x0057D9));
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(e -> {
        	dispose();
        	new Login().setVisible(true);
        });
        panel.add(cancelButton);
        
        
        return panel;
    }

    private JTextField createPlaceholderTextField(String placeholder, int y) {
        JTextField textField = new JTextField(placeholder);
        textField.setBounds(50, y, 200, 30);
        setPlaceholderBehavior(textField, placeholder);
        return textField;
    }

    private JPasswordField createPlaceholderPasswordField(String placeholder, int y) {
        JPasswordField passwordField = new JPasswordField(placeholder);
        passwordField.setBounds(50, y, 200, 30);
        setPlaceholderBehavior(passwordField, placeholder);
        return passwordField;
    }
    private JComboBox<String> createPlaceholderComboBox(String[] items, int y){
    	JComboBox<String> ComboBox = new JComboBox<>(items);
    	ComboBox.setBounds(150, y, 100, 30);
    	return ComboBox;
    }

    private void setPlaceholderBehavior(JTextField textField, String placeholder) {
        textField.setForeground(Color.GRAY);
        textField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void handleRegister(ActionEvent event) {
        String username = usernameField.getText().trim();
        String phone = phoneField.getText().trim();
        String password = new String(passwordField.getPassword());
        String type = cbType.getSelectedItem().toString().trim();
        
        
        if (username.isEmpty() || phone.isEmpty() || password.isEmpty() || (!username.startsWith("@") && type.isEmpty())) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!phone.matches("^[0-9]{10,15}$")) {
            JOptionPane.showMessageDialog(this, "Phone number must be 10 to 15 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (matchAnotherCustomerPhoneInDataBase(phone)) {
        	JOptionPane.showMessageDialog(this, "Phone number already used. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        	return;
        }
        String insertQuery;
        boolean isStaff = username.startsWith("@admin");

        if (isStaff) {
            // Staff registrations
            insertQuery = "INSERT INTO Staff (Staff_Name, Staff_Mail, Staff_Pass) VALUES (?, ?, ?)";
        } else {
            // Customer registration
            insertQuery = "INSERT INTO Customer (CustomerName , CustomerPhoneNumber, CustomerPass, CustomerType) VALUES (?, ?, ?, ?)";
        }

        try (Connection connection = DatabaseOperation.connectToDataBase();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, password);

            if (!isStaff) {
                // Add the fourth parameter only for customer registration
                preparedStatement.setString(4, type);
            }

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new Login().setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private boolean matchAnotherCustomerPhoneInDataBase(String Phone) {
    	boolean matchFound = false;
    	String query = "SELECT COUNT(*) FROM Customer WHERE CustomerPhoneNumber = ?";
    	
    	try (Connection connection = DatabaseOperation.connectToDataBase();
    		PreparedStatement preparedStatement = connection.prepareStatement(query);){
    		
    		preparedStatement.setString(1, Phone);
    		ResultSet resultset = preparedStatement.executeQuery();
    			if (resultset.next()) {
    				int count = resultset.getInt(1);
    				matchFound = count > 0;
    			}
    		}
    	catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

    	}
    	return matchFound;
    }
}
