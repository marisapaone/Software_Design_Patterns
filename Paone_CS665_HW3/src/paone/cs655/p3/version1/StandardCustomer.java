package paone.cs655.p3.version1;

import java.util.Date;

//Concrete class that extends the Customer class
public class StandardCustomer extends Customer {
    public StandardCustomer(String name, String customerId, Date registrationDate) {
        super(name, customerId, registrationDate);
        System.out.println("::Standard Customer");
    }
}
