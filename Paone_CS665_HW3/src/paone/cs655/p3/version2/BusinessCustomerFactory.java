package paone.cs655.p3.version2;

import java.util.Date;

//Factory class that extends CustomerFactory
public class BusinessCustomerFactory extends CustomerFactory{

    public Customer createCustomer(String name, String customerId, Date registrationDate) {
        System.out.println("Creating Business Customer...");
        CustomerFactory.getType();
        return new BusinessCustomer(name, customerId, registrationDate);
    }
}
