package gui;

import javax.swing.*;
import java.awt.*;
import management.BankingSystem;

public class MenuPanel extends JPanel {
    public MenuPanel(){

        JLabel welcomeMessage = new JLabel("Welcome, " +BankingSystem.getLoggedInAccount().getFirstName()
                + " " + BankingSystem.getLoggedInAccount().getLastName());
        welcomeMessage.setBounds(10, 10, 400, 40);
        add(welcomeMessage);

    }
}
