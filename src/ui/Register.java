//package ui;
//
//import java.awt.Color;
//import dao.THANHVIENDAOImpl;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//import java.lang.invoke.ConstantBootstraps;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.swing.SpinnerDateModel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JFormattedTextField;
//import javax.swing.JSpinner;
//import java.util.Date;
//import java.util.Calendar;
//import dao.Constant;
//import dao.THANHVIENDAO;
//import dao.THANHVIENDAOImpl;
//public class Register extends JFrame {
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private JTextField txtEnterYourPhone;
//	private THANHVIENDAO thanhviendao;
//
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Register frame = new Register();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Register() {
//			try {
//				Connection connection = DriverManager.getConnection(Constant.String_DB_Url, Constant.username, Constant.password);
//				if (connection != null) {
//					JOptionPane.showMessageDialog(null, "Message" ,"Database connected successfully.", JOptionPane.INFORMATION_MESSAGE);
//				}else {
//						JOptionPane.showMessageDialog(null, "Error" ,"Error connection.", JOptionPane.ERROR_MESSAGE);
//					}
//				}
//			
//			catch (SQLException e) {
//				e.printStackTrace();
//			}
//			JFrame frame = new JFrame("Login");
//	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        frame.setSize(400, 500);
//	        frame.getContentPane().setLayout(null);
//
//	        frame.getContentPane().setBackground(new Color(0x2196F3)); // Blue background
//
//	        JPanel panel = new JPanel();
//	        panel.setBounds(50, 81, 321, 300);
//	        panel.setBackground(Color.WHITE);
//	        panel.setLayout(null);
//	        frame.getContentPane().add(panel);
//
//	        JLabel titleLabel = new JLabel("Register");
//	        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//	        titleLabel.setForeground(new Color(0x0057D9));
//	        titleLabel.setBounds(94, 21, 102, 30);
//	        panel.add(titleLabel);
//
//	        JTextField usernameField = new JTextField();
//	        usernameField.setToolTipText("");
//	        usernameField.setBounds(49, 66, 200, 30);
//	        usernameField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//	        String placeholder = " Enter your username";
//	        usernameField.setText(placeholder);
//	        usernameField.setForeground(java.awt.Color.GRAY);
//	        usernameField.addFocusListener(new FocusListener() {
//
//				@Override
//				public void focusGained(FocusEvent e) {
//					// TODO Auto-generated method stub
//					if (usernameField.getText().equals(placeholder)) {
//	                    usernameField.setText("");
//	                    usernameField.setForeground(java.awt.Color.BLACK);
//	                }
//				}
//
//				@Override
//				public void focusLost(FocusEvent e) {
//					// TODO Auto-generated method stub
//					if (usernameField.getText().isEmpty()) {
//	                    usernameField.setText(placeholder);
//	                    usernameField.setForeground(java.awt.Color.GRAY);
//	                }
//				}
//	        });
//	        panel.add(usernameField);
//	        
//	        JTextField emailField = new JTextField();
//	        emailField.setToolTipText("");
//	        emailField.setBounds(49, 149, 200, 30);
//	        emailField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//	        String placeholder3 = " Enter your Email";
//	        emailField.setText(placeholder3);
//	        emailField.setForeground(java.awt.Color.GRAY);
//	        emailField.addFocusListener(new FocusListener() {
//
//				@SuppressWarnings("deprecation")
//				@Override
//				public void focusGained(FocusEvent e) {
//					// TODO Auto-generated method stub
//					if (emailField.getText().equals(placeholder3)) {
//						emailField.setText("");
//						emailField.setForeground(java.awt.Color.BLACK);
//	                }
//				}
//
//				@SuppressWarnings("deprecation")
//				@Override
//				public void focusLost(FocusEvent e) {
//					// TODO Auto-generated method stub
//					if (emailField.getText().isEmpty()) {
//						emailField.setText(placeholder3);
//						emailField.setForeground(java.awt.Color.GRAY);
//	                }
//				}
//
//	        });
//	        panel.add(emailField);
//
//	        JPasswordField passwordField = new JPasswordField();
//	        passwordField.setBounds(49, 110, 200, 30);
//	        passwordField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//	        String placeholder2 = " Enter ";
//	        passwordField.setText(placeholder2);
//	        passwordField.setForeground(java.awt.Color.GRAY);
//	        passwordField.addFocusListener(new FocusListener() {
//
//				@SuppressWarnings("deprecation")
//				@Override
//				public void focusGained(FocusEvent e) {
//					// TODO Auto-generated method stub
//					if (passwordField.getText().equals(placeholder2)) {
//						passwordField.setText("");
//						passwordField.setForeground(java.awt.Color.BLACK);
//	                }
//				}
//
//				@SuppressWarnings("deprecation")
//				@Override
//				public void focusLost(FocusEvent e) {
//					// TODO Auto-generated method stub
//					if (passwordField.getText().isEmpty()) {
//						passwordField.setText(placeholder2);
//	                    passwordField.setForeground(java.awt.Color.GRAY);
//	                }
//				}
//
//	        });
//	        panel.add(passwordField);
//	        
//	        JButton btnRegister = new JButton("Confirm");
//	        btnRegister.setForeground(new Color(51, 0, 255));
//	        btnRegister.setFocusPainted(false);
//	        btnRegister.setBackground(Color.WHITE);
//	        btnRegister.setBounds(87, 240, 123, 30);
//	        btnRegister.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				frame.setVisible(false);
//				new Login();
//			}
//				
//			});
//	        panel.add(btnRegister);
//	        
//	        txtEnterYourPhone = new JTextField();
//	        txtEnterYourPhone.setToolTipText("");
//	        txtEnterYourPhone.setText(" Phone Number");
//	        txtEnterYourPhone.setForeground(Color.GRAY);
//	        txtEnterYourPhone.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//	        txtEnterYourPhone.setBounds(49, 190, 105, 30);
//	        panel.add(txtEnterYourPhone);
//	        
//	        
//	        
//	        
//	        
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		
//		
//		
//		frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//	}
//}
package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import dao.THANHVIENDAO;
import dao.THANHVIENDAOImpl;
import dao.Constant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField usernameField, phoneField, typeField;
    private JPasswordField passwordField;
    private THANHVIENDAO thanhVienDAO;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Register frame = new Register();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Register() {
        thanhVienDAO = new THANHVIENDAOImpl();

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

        typeField = createPlaceholderTextField("Enter user type", 200);
        panel.add(typeField);

        JButton registerButton = new JButton("Confirm");
        registerButton.setBounds(90, 260, 120, 30);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(0x0057D9));
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(this::handleRegister);
        panel.add(registerButton);

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
        String type = typeField.getText();
        
        
        if (username.isEmpty() || phone.isEmpty() || password.isEmpty() || (!username.startsWith("@") && type.isEmpty())) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!phone.matches("^[0-9]{10,15}$")) {
            JOptionPane.showMessageDialog(this, "Phone number must be 10 to 15 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String insertQuery;
        boolean isStaff = username.startsWith("@admin");

        if (isStaff) {
            // Staff registration
            insertQuery = "INSERT INTO Staff (Staff_Name, Staff_Mail, Staff_Pass) VALUES (?, ?, ?)";
        } else {
            // Customer registration
            insertQuery = "INSERT INTO Customer (Username, CustomerPhoneNumber, UserPassword, CustomerType) VALUES (?, ?, ?, ?)";
        }

        String dbUrl = "jdbc:sqlserver://ADMIN\\SQLEXPRESS:1433;databaseName=QLRCP;encrypt=true;trustServerCertificate=true;";
        String dbUsername = "sa";
        String dbPassword = "duy15122006";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
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
}
