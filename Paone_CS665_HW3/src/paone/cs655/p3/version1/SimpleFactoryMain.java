package paone.cs655.p3.version1;

import paone.cs655.p3.version2.CustomerFactory;

//Uses the simple factory design pattern to create three types of customers, standard, preferred and business
public class SimpleFactoryMain {

    public static void main (String[] args){

        //Creates an instance of the SimpleCustomerFactory class
        SimpleCustomerFactory factory = new SimpleCustomerFactory();

        System.out.println("\nPart 3: Version 1 using simple factory");

        //Using the simple factory to create customers with a specific type
        Customer customer1 = factory.createCustomer("BusinessCustomer", "Alice", "011-11-1111", CustomerFactory.getDate("June 1, 2022"));

        Customer customer2 = factory.createCustomer("PreferredCustomer", "Bob", "012-11-1111", CustomerFactory.getDate("June 4, 2022"));

        Customer customer3 = factory.createCustomer("StandardCustomer", "Tom", "013-11-1111", CustomerFactory.getDate("June 5, 2022"));


    }


}
