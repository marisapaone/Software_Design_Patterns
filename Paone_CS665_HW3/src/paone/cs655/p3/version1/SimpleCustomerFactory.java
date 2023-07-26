package paone.cs655.p3.version1;

import java.util.Date;

//Simple Factory Class for creating customers
public class SimpleCustomerFactory {


    public Customer createCustomer(String type, String name, String customerId, Date registrationDate ) {
        Customer customer = null;
        if (type.equals("BusinessCustomer")) {
            System.out.println("Creating Business Customer...");

            customer = new BusinessCustomer(name, customerId, registrationDate);


        } else if (type.equals("StandardCustomer")) {
            System.out.println("Creating Standard Customer...");

            customer = new StandardCustomer(name, customerId, registrationDate);


        } else if (type.equals("PreferredCustomer")) {
            System.out.println("Creating Preferred Customer...");

            customer = new PreferredCustomer(name, customerId, registrationDate);


        }
        return customer;
    }
}

