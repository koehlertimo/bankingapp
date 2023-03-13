package entities;

import java.util.Date;

public class Transaction extends Entity {
    private User sender;
    private User receiver;
    private Date time;
    private double amount;
    private String note;

    public Transaction(int id, User sender, User receiver, Date time, double amount, String note) {
        super(id);
        this.sender = sender;
        this.receiver = receiver;
        this.time = time;
        this.amount = amount;
        this.note = note;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String convertToCSVString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.sender.getId());
        sb.append(";");
        sb.append(this.receiver.getId());
        sb.append(";");
        sb.append(this.amount);
        sb.append(";");
        sb.append(this.time.getTime());
        sb.append(";");
        sb.append(this.note);

        return sb.toString();
    }
}
