package paone.cs655.p3.version2;

import java.util.Date;

//Factory class that extends CustomerFactory
public class PreferredCustomerFactory extends CustomerFactory {

    public Customer createCustomer(String name, String customerId, Date registrationDate) {
        System.out.println("Creating Preferred Customer...");
        CustomerFactory.getType();
        return new PreferredCustomer(name, customerId, registrationDate);
    }
}
