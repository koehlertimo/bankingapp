package gui;

import javax.swing.*;
import java.awt.*;

public class GUIController {
    private static JFrame frame = new JFrame("Banking Application");
    private static JPanel mainPanel = new JPanel();
    private static CardLayout card = new CardLayout();
    private static JPanel login = new LoginPanel();
    private static JPanel register = new RegisterPanel();
    private static JPanel menu = new MenuPanel();

    public GUIController(){
        frame.setSize(800,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        mainPanel.setLayout(card);

        mainPanel.add(login, "login");
        mainPanel.add(register, "register");
        mainPanel.add(menu, "menu");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public static void showLoginScreen(){
        card.show(mainPanel, "login");
    }
    public static void showRegisterScreen(){
        card.show(mainPanel, "register");
    }
    public static void showMenuScreen(){
        card.show(mainPanel, "menu");
    }


}
