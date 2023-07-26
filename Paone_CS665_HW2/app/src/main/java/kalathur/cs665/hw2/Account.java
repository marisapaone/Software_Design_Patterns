package kalathur.cs665.hw2;

import kalathur.cs665.hw2.enumTypes.AccountStatus;
import kalathur.cs665.hw2.exceptions.BankException;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public abstract class Account {

    private final String accountId;
    private final Date openDate;
    private Date closeDate;

    private final Customer primaryOwner;
    private Customer jointOwner;

    private AccountStatus accountStatus;

    private Date jointOwnershipDate;

    private int currentBalance;

    private final List<Transaction> transactionList;

    public Account(Customer primaryOwner, String accountId, Date openDate) {
        this.accountId = accountId;
        this.openDate = openDate;
        this.accountStatus = AccountStatus.Open;
        this.currentBalance = 0;
        this.transactionList = new ArrayList<>();
        this.primaryOwner = primaryOwner;
        primaryOwner.addAccount(this);
    }

    public Customer getPrimaryOwner() {
        return this.primaryOwner;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public Date getOpenDate() {
        return this.openDate;
    }

    public AccountStatus getAccountStatus() {
        return this.accountStatus;
    }

    public int getCurrentBalance() {
        return this.currentBalance;
    }

    public void setJointOwner(Customer jointOwner, Date jointOwnershipDate) {
        this.jointOwner = jointOwner;
        this.jointOwnershipDate = jointOwnershipDate;
        jointOwner.addAccount(this);
    }

    public Customer getJointOwner() {
        return this.jointOwner;
    }

    public Date getJointOwnershipDate() {
        return this.jointOwnershipDate;
    }

    protected synchronized void addTransaction(Transaction t) {

        if (this.accountStatus == AccountStatus.Close)
            throw new BankException("Account " + this.getAccountId() + "closed... Transaction not allowed");

        if (t instanceof DepositTransaction) {
        
        	
            /* If the deposit is greater than 0 dollars (not a negative amount) then proceed with deposit
             * The transaction is added to the transactionList, and the endingbalance is set to the currentbalance
             * and the transaction is printed.
             */
        	if (t.getTransactionAmount()>0) {
        		deposit(t.getTransactionAmount());
            	transactionList.add(t);
            	t.setEndingBalance(currentBalance);
            	t.print(this);
        	}
        	else {
        		t.setDescription("Cannot deposit 0 dollars or less, deposit ignored");
        		transactionList.add(t);
        		t.setEndingBalance(currentBalance);
        		t.print(this);
        	}
        
        	
        	

        } else if (t instanceof WithdrawTransaction) {

            /* If the transaction amount is less than the current balance, proceed with withdrawl. 
              otherwise the description of the transaction is changed to "Not enough balance... "
              Then the transaction is added to the transactionList.
              The ending balance of the transaction is set to the account's current balance,
              and the transaction's print method is called
             */
        	if (t.getTransactionAmount() <= currentBalance) {
        		withdraw(t.getTransactionAmount());
            	transactionList.add(t);
            	t.setEndingBalance(currentBalance);
            	t.print(this);
        	}
        	else {
        		t.setDescription("Not enough balance, withdrawl ignored");
        		transactionList.add(t);
        		t.setEndingBalance(currentBalance);
        		t.print(this);
        	}


        } else if (t instanceof TransferTransaction) {

            TransferTransaction tr = (TransferTransaction) t;

            if (tr.getToAccount().accountStatus == AccountStatus.Close)
                throw new BankException("Account " + this.getAccountId() + " closed... Transaction not allowed");

            tr.setDescription("Transfer from " + this.getAccountId() + " to " + tr.getToAccount().getAccountId());
            this.transactionList.add(tr);
            tr.getToAccount().transactionList.add(tr);
            tr.print(null);
        }

    }

    private synchronized void deposit(int amount) {
        this.currentBalance += amount;
    }

    private synchronized void withdraw(int amount)  {
        this.currentBalance -= amount;
    }

    public synchronized void closeAccount(Date closeDate) {
        this.accountStatus = AccountStatus.Close;
        this.closeDate = closeDate;
    }

    public void printStatement(Date toDate) {

        System.out.println("\n\tTransactions for Account " + this.accountId + " Primary Owner: " + this.primaryOwner.getName() + "\n");

        /* The transactionList is iterated over, and the print method is called 
         * only if the Date entered is after the transactions were made
         * If the compareTo line was changed to < 0, then only transactions after that date would be posted.
         * The >= 0 means the date inputed MUST be the date of the transaction OR transactions before that date. */

        for (Transaction t: transactionList) {
        	if (toDate.compareTo(t.getTransactionDate()) >= 0) {
        		t.print(this);
        	}
        }
    }

}


