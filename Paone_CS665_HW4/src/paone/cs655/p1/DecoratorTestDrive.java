package paone.cs655.p1;

import paone.cs655.p1.enumTypes.AccountType;
import paone.cs655.p1.exceptions.BankException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

//Main method to test the decorator pattern
public class DecoratorTestDrive {
    public static void main (String[]args){

        //Creating bank instance and an account for transaction testing
        Bank bankApp = Bank.getBankInstance();
        String aliceId = "011-11-1111";
        //Creating a customer and account to use for this decorator pattern
        bankApp.createCustomer("Alice", aliceId, getDate("June 1, 2022"));
        bankApp.createAccount(aliceId, AccountType.Checking,
                "01-001",  getDate("June 1, 2022"), 1000);


        System.out.println();
        System.out.println("Testing Deposit Transaction by itself");
        Transaction transaction = new DepositTransaction(getDate("June 3, 2022"),
                200, bankApp.lookupCustomer(aliceId), bankApp.lookupAccount("01-001"));
        System.out.println(transaction.getDescription());

        System.out.println();
        System.out.println("Testing Deposit Transaction with Logging");
        Transaction transaction2 = new LoggingDecorator(new DepositTransaction(getDate("June 4, 2022"),
                4000, bankApp.lookupCustomer(aliceId), bankApp.lookupAccount("01-001")));
        System.out.println(transaction2.getDescription());

        System.out.println();
        System.out.println("Testing Deposit Transaction with Security");
        Transaction transaction3 = new SecurityDecorator(new DepositTransaction(transaction));
        System.out.println(transaction3.getDescription());

        System.out.println();
        System.out.println("Testing Deposit Transaction with Logging and Security");
        Transaction transaction4 = new LoggingDecorator(new SecurityDecorator(new DepositTransaction(transaction)));
        System.out.println(transaction4.getDescription());

        System.out.println();
        System.out.println("Testing Withdrawl Transaction by itself");
        Transaction transaction5 = new WithdrawTransaction(getDate("June 8, 2022"),
                500, bankApp.lookupCustomer(aliceId), bankApp.lookupAccount("01-001"));
        System.out.println(transaction5.getDescription());

        System.out.println();
        System.out.println("Testing Withdrawl Transaction with Logging and Security");
        Transaction transaction6 = new LoggingDecorator(new SecurityDecorator(new WithdrawTransaction(transaction5)));
        System.out.println(transaction6.getDescription());

    }



    private static Date getDate(String dateStr) {
        try {
            return DateFormat.getDateInstance().parse(dateStr);
        } catch (ParseException e) {
            throw new BankException("Invalid Date... " + e.getMessage());
        }

    }
}
