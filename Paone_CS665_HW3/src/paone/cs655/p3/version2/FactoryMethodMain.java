package paone.cs655.p3.version2;

//This class uses the factory method design pattern to create standard, business and preferred customers using their
//own factories
public class FactoryMethodMain {

    public static void main (String[] args){
        System.out.println("Part 3: Version 2 using FactoryMethod\n");

        // Creating a Standard Customer using the Standard Customer Factory Method
        CustomerFactory customerFactory = new StandardCustomerFactory();
        Customer customer1 = customerFactory.createCustomer("Alice", "011-11-1111", CustomerFactory.getDate("June 1, 2022"));

        // Creating a Preferred Customer using the Preferred Customer Factory Method
        customerFactory = new PreferredCustomerFactory();
        Customer customer2 = customerFactory.createCustomer("Bob", "012-11-1111", CustomerFactory.getDate("June 1, 2022"));

        // Creating a Business Customer using the Business Customer Factory Method
        customerFactory = new BusinessCustomerFactory();
        Customer customer3 = customerFactory.createCustomer("Tom", "013-11-1111", CustomerFactory.getDate("June 1, 2022"));

    }
}
