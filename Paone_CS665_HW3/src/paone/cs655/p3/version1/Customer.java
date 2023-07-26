package paone.cs655.p3.version1;

import paone.cs655.p1.Account;
import paone.cs655.p1.exceptions.BankException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Abstract class that is extended by the BusinessCustomer , PreferredCustomer and StandardCustomer class
public abstract class Customer {
       String name;
       String customerId;
       Date registrationDate;
      private final List<Account> accountList;


    public Customer(String name, String customerId, Date registrationDate) {
        this.name = name;
        this.customerId = customerId;
        this.registrationDate = registrationDate;
        this.accountList = new ArrayList<>();
        System.out.print("**Customer**");
    }


    public String getName() {
        return this.name;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void addAccount(Account account) {
    	 
    	// If the account isn't already in the accountList, add it. 
    	if (!accountList.contains(account)) {
    		accountList.add(account);
    	}
    }


    public void printStatement(Date toDate) {

        System.out.println("\nBEGIN ACCOUNT STATEMENT - " + this.getName() + " - " + DateFormat.getDateInstance().format(toDate));

        /*Iterates over the customer's accountList and invokes printStatement for each account */
        for (Account account: accountList) {
            
        	account.printStatement(toDate);
        }

        System.out.println("\nEND ACCOUNT STATEMENT\n");
    }

    public static Date getDate(String dateStr) {
        try {
            return DateFormat.getDateInstance().parse(dateStr);
        } catch (ParseException e) {
            throw new BankException("Invalid Date... " + e.getMessage());
        }

    }

}
