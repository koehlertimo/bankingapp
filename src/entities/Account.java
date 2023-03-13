package entities;


import java.util.Date;

public class Account extends Entity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String street;
    private String houseNumber;
    private int postalCode;
    private String city;
    private String country;
    private Date creationDate;

    public Account(int id, String firstName, String lastName, String email, String password, String street,
                   String houseNumber, int postalCode, String city, String country, Date creationDate) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.creationDate = creationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public String convertToCSVString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.getId());
        sb.append(";");
        sb.append(this.firstName);
        sb.append(";");
        sb.append(this.lastName);
        sb.append(";");
        sb.append(this.email);
        sb.append(";");
        sb.append(this.password);
        sb.append(";");
        sb.append(this.street);
        sb.append(";");
        sb.append(this.houseNumber);
        sb.append(";");
        sb.append(this.city);
        sb.append(";");
        sb.append(this.postalCode);
        sb.append(";");
        sb.append(this.country);
        sb.append(";");
        sb.append(this.creationDate.getTime());
        return sb.toString();
    }
}
