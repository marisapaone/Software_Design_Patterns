package paone.cs655.p3;

import paone.cs655.p1.exceptions.BankException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

//Main client class to test the adapter method
public class AdapterTestDrive {

    public static void main (String args[]){

        //Creates a customer with a name, id, number, address, and a date created.
        Customer customer1 = new Customer("Alice", "01-002", "342-234-5234",
                "8 Burgundy St, Boston, MA", getDate("June 3, 2022"));

        Customer customer2 = new Customer("Bob", "01-002", "346-234-5234",
                "123 Main St, Boston, MA", getDate("June 4, 2022"));
        //Creates an inHouseVerifier object
        InHouseVerifier inHouseVerifier = new InHouseVerifier();

        //Runs the inHouseVerifier verify customer method on the customer that was created
        inHouseVerifier.verifyCustomer(customer1);

        //Creates an abcValidator and an ABCAdapter and passes the validator in the adapter
        ABCValidator abcValidator = new ABCValidator();
        IVerify adapter1 = new ABCAdapter(abcValidator);

        //Creates a xyzchecker object and an ABCAdapter and passes the checker in the adapter
        XYZChecker xyzChecker = new XYZChecker();
        IVerify adapter2 = new ABCAdapter(xyzChecker);

        //running the verifyCustomer method for both adapters (xyzchecker and abcValidator)
        adapter1.verifyCustomer(customer1);
        inHouseVerifier.verifyCustomer(customer2);
        adapter2.verifyCustomer(customer2);
    }

    private static Date getDate(String dateStr) {
        try {
            return DateFormat.getDateInstance().parse(dateStr);
        } catch (ParseException e) {
            throw new BankException("Invalid Date... " + e.getMessage());
        }

    }
}
