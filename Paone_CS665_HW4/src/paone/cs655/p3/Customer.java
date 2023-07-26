package paone.cs655.p3;

import paone.cs655.p1.Account;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//The Customer class was modified to include number and address variables along with their encapsulation methods.
//the variables were also added to the Cusomter constructor.
public class Customer {
    private final String name;
    private final String number;
    private final String address;
    private final String customerId;
    private final Date registrationDate;
    private final List<Account> accountList;

    public Customer(String name, String customerId, String number, String address, Date registrationDate) {
        this.name = name;
        this.customerId = customerId;
        this.registrationDate = registrationDate;
        this.accountList = new ArrayList<>();
        this.number = number;
        this.address = address;

    }

    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public String getNumber() {
        return this.number;
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


}
