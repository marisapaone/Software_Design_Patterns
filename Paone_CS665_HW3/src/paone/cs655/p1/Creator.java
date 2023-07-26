package paone.cs655.p1;

import paone.cs655.p1.exceptions.BankException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

//Main class to test the abstract factory design pattern
public class Creator {

    //This main method tests each factory (bank name variation)
    public static void main(String[] args){

        System.out.print("--Testing Basic version of Accounts--");
        openAccounts(new UnaffiliatedAccountFactory());
        System.out.println("\n");

        System.out.println("--Testing Bank of America version of Accounts--");
        openAccounts(new BankOfAmericaFactory());
        System.out.println();

        System.out.println("--Testing Chase version of Accounts--");
        openAccounts(new ChaseFactory());
        System.out.println();

    }

    //This method will get a bankApp instance and create and name a customer, and open two accounts for that customer,
    //a checkingAccount and a savingsAccount
    public static void openAccounts(AccountFactory accountFactory){

        Bank bankApp = Bank.getBankInstance();

        String aliceId = "011-11-1111";

        if  (!bankApp.customerMap.containsKey(aliceId)) {
            bankApp.createCustomer("Alice", aliceId, getDate("June 1, 2022"));
        }

        CheckingAccount checkingAccount = accountFactory.createCheckingAccount(bankApp.lookupCustomer(aliceId), aliceId, getDate("June 1, 2022"), 1000 );
        SavingsAccount savingsAccount = accountFactory.createSavingsAccount(bankApp.lookupCustomer(aliceId), aliceId, getDate("June 1, 2022"), 1000);

    }

    private static Date getDate(String dateStr) {
        try {
            return DateFormat.getDateInstance().parse(dateStr);
        } catch (ParseException e) {
            throw new BankException("Invalid Date... " + e.getMessage());
        }

    }
}
