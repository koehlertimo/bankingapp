package entities;

import management.BankingSystem;

import java.util.Date;

public class User extends Account {
    private double balance;
    private int numberOfTransactions;
    private Transaction[] transactions;

    public User(int id, String firstName, String lastName, String email, String password, String street, String houseNumber,
                int postalCode, String city, String country, double balance, int numberOfTransactions, Date creationDate) {
        super(id, firstName, lastName, email, password, street, houseNumber, postalCode, city, country, creationDate);
        this.balance = balance;
        this.numberOfTransactions = numberOfTransactions;
    }

    public User(String firstName, String lastName, String email, String password, String street, String houseNumber,
                int postalCode, String city, String country) {
        super(BankingSystem.generateID(), firstName, lastName, email, password, street, houseNumber, postalCode, city,
                country, new Date());
        this.balance = 0.0;
        this.numberOfTransactions = 0;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(int numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    private void increaseBalance(double amount){
        this.balance += amount;
        numberOfTransactions++;
    }
    private void decreaseBalance(double amount){
        this.balance -= amount;
        numberOfTransactions++;
    }

    private boolean doesBalancesReachesZero(double amount){
        return !(balance - amount <= 0.00);
    }

    public String convertToCSVString(){
        String str = super.convertToCSVString() + ";" + this.balance + ";" + this.numberOfTransactions;
        return str;
    }

}
