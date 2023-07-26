package paone.cs655.p1;

import paone.cs655.p1.enumTypes.AccountType;
import paone.cs655.p1.enumTypes.TransactionType;
import paone.cs655.p1.exceptions.BankException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    final Map<String, Customer> customerMap;
    private final Map<String, Account> accountMap;

    private static Bank bankInstance;

    private Bank() {
        customerMap = new HashMap<>();
        accountMap  = new HashMap<>();
    }

    public static synchronized Bank getBankInstance() {
        if (bankInstance == null) {
            bankInstance = new Bank();
        }
        return bankInstance;
    }

    public synchronized Customer createCustomer(String customerName, String customerId, Date registrationDate)
            throws BankException {

    	/* Creates a customer object and checks if that object is already in the customerMap,
    	 * meaning it would be a customer that exists already, if so throw an exception that the customer already exists
    	 * If the customer doesn't exist in the map, the customer will be added to the map. 
    	 */
    	Customer customer = new Customer (customerName, customerId, registrationDate);

        if (customerMap.containsKey(customer.getCustomerId())){
            throw new BankException("Customer already exists");
        }
        else {
            customerMap.put(customerId, customer);
        }

        return customer;

    }

    public synchronized Customer lookupCustomer(String customerId)
            throws BankException {

    	/* If the customerId is not in the customerMap, throw an exception that the customer does not exist.
    	 * If the customerId is in the Map, then get the customer object by its key (customerId) and return that object.
    	 */
    	if (!customerMap.containsKey(customerId)) {
    		 throw new BankException("Customer does not exist.");
    	}
        else {
            Customer lookupCustomer = customerMap.get(customerId);
            return lookupCustomer;
        }
    }

    public synchronized Account createAccount(String customerId, AccountType accountType,
                                              String accountId, Date openDate, int initialAmount)
            throws BankException {

    	/* If the initial amount is greater than $100, (which is the minimum to open an account), then proceed 
    	 * with account opening. If its not an exception is thrown. 
    	 * If the account type is a checking account, a CheckingAccount object is made, if its savings a savings account
    	 * object is made.
    	 */
    	
        if (initialAmount >= 100){
            if (accountType == AccountType.Checking){
                Account account = new CheckingAccount(customerMap.get(customerId), accountId, openDate, initialAmount);
                accountMap.put(accountId, account);
                return account;
            }
            else if (accountType == AccountType.Savings) {
                Account account = new SavingsAccount(customerMap.get(customerId), accountId, openDate, initialAmount);
                accountMap.put(accountId, account);
                return account;
            }
            else {
            	throw new BankException("Invalid account type.");
            }
        }
        else{
           throw new BankException("Initial amount is not enough to open an account");
        }

    }

    public synchronized Account lookupAccount(String accountId) {

    	/* If the accountId is not in the accountMap, throw an exception that the account does not exist.
    	 * if not then get the account object by its key (accountId) and return that object.
    	 */
        if (!accountMap.containsKey(accountId)) {
        	throw new BankException("Account does not exist.");
        }
        else {
        	Account lookupAccount = accountMap.get(accountId);
            return lookupAccount;
        }
      
    }

    public synchronized void setJointOwner(String accountId, String primaryOwnerId,
                                           String jointOwnerId, Date jointOwnershipDate) {

        Account account = this.lookupAccount(accountId);
        Customer primaryOwner = this.lookupCustomer(primaryOwnerId);
        Customer jointOwner   = this.lookupCustomer(jointOwnerId);

        if ((account != null) && (primaryOwner != null) && (jointOwner != null)) {
            if ( (account.getPrimaryOwner() == primaryOwner) && (account.getJointOwner() == null) ) {
                account.setJointOwner(jointOwner, jointOwnershipDate);
            }
        }


    }

    public synchronized void createTransaction(TransactionType transactionType, Date date, int amount,
                                               String customerId, String sourceAccountId,
                                               String destinationAccountId) {

        /* Based on the transactionType, either makeDeposit(...), makeWithdrawal(...), or makeTransfer(...) is invoked.
         */
        switch (transactionType) {

            case Deposit -> {
            	makeDeposit(date, amount, customerId, sourceAccountId );
            	break;
            }
            case Withdraw -> {
            	makeWithdrawal(date, amount, customerId, sourceAccountId);
            	break;
            }
            case Transfer -> {
            	makeTransfer(date, amount, customerId, sourceAccountId, destinationAccountId);

            }
        }
    }

    private synchronized void makeDeposit(Date date, int amount, String customerId, String accountId) {
        Customer customer = this.lookupCustomer(customerId);
        Account account = this.lookupAccount(accountId);
        new DepositTransaction(date, amount, customer, account);
    }

    private synchronized void makeWithdrawal(Date date, int amount, String customerId, String accountId) {
        Customer customer = this.lookupCustomer(customerId);
        Account account = this.lookupAccount(accountId);
        if (account != null &&
                ((account.getPrimaryOwner() == customer) ||
                        (account.getJointOwner() != null && account.getJointOwner() == customer)) ) {
            new WithdrawTransaction(date, amount, customer, account);
        } else
            new BankException("Customer is not owner or joint owner");
    }

    private synchronized void makeTransfer(Date date, int amount, String customerId, String fromAccountId, String toAccountId) {
        Customer customer = this.lookupCustomer(customerId);
        Account fromAccount = this.lookupAccount(fromAccountId);
        Account toAccount = this.lookupAccount(toAccountId);
        if (fromAccount != null &&
                ((fromAccount.getPrimaryOwner() == customer) ||
                        (fromAccount.getJointOwner() != null && fromAccount.getJointOwner() == customer)) ){
            new TransferTransaction(date, amount, customer, fromAccount, toAccount);
        } else
            new BankException("Customer is not owner or joint owner");
    }

    public synchronized void printStatement(String customerId, Date toDate) {
        Customer customer = this.lookupCustomer(customerId);
        if (customer != null){
         customer.printStatement(toDate);
        }
    }

}
