package kalathur.cs665.hw2;

import java.text.DateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private final String name;
    private final String customerId;
    private final Date registrationDate;
    private final List<Account> accountList;

    public Customer(String name, String customerId, Date registrationDate) {
        this.name = name;
        this.customerId = customerId;
        this.registrationDate = registrationDate;
        this.accountList = new ArrayList<>();
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


}
