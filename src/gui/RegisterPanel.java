package gui;

import com.sun.net.httpserver.Authenticator;
import entities.Account;
import entities.User;
import jdk.jshell.execution.Util;
import management.BankingSystem;
import utils.Hash;
import utils.ValidationUtils;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class RegisterPanel extends JPanel {
    private JTextField firstNameInput = new JTextField();
    private JTextField lastNameInput = new JTextField();
    private JTextField streetInput = new JTextField();
    private JTextField houseNumberInput = new JTextField();
    private JTextField postalCodeInput = new JTextField();
    private JTextField cityInput = new JTextField();
    private JTextField countryInput = new JTextField();
    private JTextField emailInput = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JLabel errorLabel = new JLabel("");

    public RegisterPanel(){
        Border titleBorder = BorderFactory.createTitledBorder("Register");
        setBorder(titleBorder);
        setLayout(null);

        JLabel firstNameLabel = new JLabel("Firstname: ");
        firstNameLabel.setBounds(10, 20, 80, 25);
        add(firstNameLabel);
        firstNameInput.setBounds(80, 20, 175, 25);
        add(firstNameInput);

        JLabel lastNameLabel = new JLabel("Lastname: ");
        lastNameLabel.setBounds(275, 20, 80, 25);
        add(lastNameLabel);
        lastNameInput.setBounds(345, 20, 175, 25);
        add(lastNameInput);

        JLabel streetLabel = new JLabel("Street: ");
        streetLabel.setBounds(10, 50, 80, 25);
        add(streetLabel);
        streetInput.setBounds(80, 50, 175, 25);
        add(streetInput);

        JLabel houseNumberLabel = new JLabel("House Number: ");
        houseNumberLabel.setBounds(275, 50, 120, 25);
        add(houseNumberLabel);
        houseNumberInput.setBounds(375, 50, 40, 25);
        add(houseNumberInput);

        JLabel cityLabel = new JLabel("City: ");
        cityLabel.setBounds(10, 80, 80, 25);
        add(cityLabel);
        cityInput.setBounds(80, 80, 175, 25);
        add(cityInput);

        JLabel postalCodeLabel = new JLabel("Postalcode: ");
        postalCodeLabel.setBounds(275, 80, 80, 25);
        add(postalCodeLabel);
        postalCodeInput.setBounds(345, 80, 90, 25);
        add(postalCodeInput);

        JLabel countryLabel = new JLabel("Country: ");
        countryLabel.setBounds(10, 110, 80, 25);
        add(countryLabel);
        countryInput.setBounds(80, 110, 175, 25);
        add(countryInput);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(10, 140, 80, 25);
        add(emailLabel);
        emailInput.setBounds(80, 140, 175, 25);
        add(emailInput);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(275, 140, 80, 25);
        add(passwordLabel);
        password.setBounds(345, 140, 175, 25);
        add(password);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(0, 170, 80, 25);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        add(registerButton);

        JButton loginButton = new JButton("Back");
        loginButton.setBounds(80, 170, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIController.showLoginScreen();
            }
        });
        add(loginButton);

        errorLabel.setBounds(10, 200, 400, 25);
        errorLabel.setForeground(Color.RED);
        add(errorLabel);

        setVisible(true);
    }

    public void register(){
        try{
            errorLabel.setText("");
            errorLabel.setForeground(Color.RED);
            if(!ValidationUtils.isValidEMail(emailInput.getText())){
                errorLabel.setText("Please insert a valid email!");
                return;
            }
            if(BankingSystem.doesAccountExist(emailInput.getText())){
                errorLabel.setText("There is already an account with this email adress!");
                return;
            }
            if(!ValidationUtils.isValidPassword(Arrays.toString(password.getPassword()))){
                errorLabel.setText("Please insert a valid password! ");
                return;
            }

            BankingSystem.addAccountToArray(new User(firstNameInput.getText(), lastNameInput.getText(), emailInput.getText(),
                    Hash.generateHash(Hash.generateHash(password.getText())), streetInput.getText(), houseNumberInput.getText(),
                    Integer.parseInt(postalCodeInput.getText()), cityInput.getText(), countryInput.getText()));
            errorLabel.setForeground(Color.green);
            errorLabel.setText("The account was created successfully! Please login!");
        }catch (Exception e){
            errorLabel.setText("InValid Input, please try again!");
        }
    }
}
