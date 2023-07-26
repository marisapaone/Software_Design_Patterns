package paone.cs655.p3.version2;

import paone.cs655.p1.exceptions.BankException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

//Abstract factory class that is extended by every type of customer factory
public abstract class CustomerFactory {
    public abstract Customer createCustomer(String name, String customerId, Date registrationDate);
    public static void getType(){
        System.out.print("**Customer**");
    }

    public static Date getDate(String dateStr) {
        try {
            return DateFormat.getDateInstance().parse(dateStr);
        } catch (ParseException e) {
            throw new BankException("Invalid Date... " + e.getMessage());
        }

    }
}
