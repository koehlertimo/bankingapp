package gui;

import entities.Account;
import management.BankingSystem;
import utils.Hash;

import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class LoginPanel extends JPanel {
    private JTextField emailInput;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel errorLabel = new JLabel("");

    public LoginPanel(){
        setLayout(null);
        Border titleBorder = BorderFactory.createTitledBorder("Login");
        setBorder(titleBorder);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 20, 80, 25);
        add(emailLabel);

        emailInput = new JTextField();
        emailInput.setBounds(80, 20, 175, 25);
        add(emailInput);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10, 50, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(80, 50,175,25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(0, 80, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(80, 80, 80, 25);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIController.showRegisterScreen();
            }
        });
        add(registerButton);

        errorLabel.setBounds(10, 110, 600, 25);
        errorLabel.setForeground(Color.RED);
        add(errorLabel);
    }

    private void login(){
        System.out.println("asd");
        Account acc = BankingSystem.findAccountByMail(emailInput.getText());
        errorLabel.setText("");

        if(acc != null){
            System.out.println(Hash.generateHash(passwordField.getText()));
            if(acc.getPassword().equals(Hash.generateHash(passwordField.getText()))){
                BankingSystem.setLoggedInAccount(acc);
                GUIController.showMenuScreen();
                return;
            }
        }
        errorLabel.setText("The email or password is wrong. Please try again!");

    }
}
