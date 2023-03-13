package entities;

import java.util.Date;

public class Admin extends Account {
    public Admin(int id, String firstName, String lastName, String email, String password, String street,
                 String houseNumber, int postalCode, String city, String country, Date creationDate) {
        super(id, firstName, lastName, email, password, street, houseNumber, postalCode, city, country,creationDate);
    }
}
