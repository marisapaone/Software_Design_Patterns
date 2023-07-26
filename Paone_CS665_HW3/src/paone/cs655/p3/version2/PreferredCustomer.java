package paone.cs655.p3.version2;

import java.util.Date;

//Concrete class that extends the customer class
public class PreferredCustomer extends Customer {
    public PreferredCustomer(String name, String customerId, Date registrationDate) {
        super(name, customerId, registrationDate);
        System.out.println("::Preferred Customer");
    }
}
