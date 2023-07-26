package paone.cs655.p1;

import java.util.Date;

//Concrete Component Class that extends the Component class Transaction
public class DepositTransaction extends Transaction {

    public DepositTransaction(Date transactionDate, int amount, Customer transactionOwner, Account toAccount) {
        super(transactionDate, amount, transactionOwner);
        if (toAccount != null)
            toAccount.addTransaction(this);
        description = getDescription() + "Deposit Transaction";
    }

    //For multi-use purposes in main, overloaded constructor that accepts transactions
    public DepositTransaction(Transaction transaction) {
        super(transaction.getTransactionDate(),
                transaction.getTransactionAmount(), transaction.getTransactionOwner());
        description = getDescription() + "Deposit Transaction";
    }

}
