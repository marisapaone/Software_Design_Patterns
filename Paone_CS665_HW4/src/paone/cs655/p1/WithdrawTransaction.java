package paone.cs655.p1;

import java.util.Date;

//Concrete Component Class that extends the Component class Transaction
public class WithdrawTransaction extends Transaction {

    public WithdrawTransaction(Date transactionDate, int amount, Customer transactionOwner, Account fromAccount) {
        super(transactionDate, amount, transactionOwner);
        if (fromAccount != null)
            fromAccount.addTransaction(this);
        description = getDescription() + "Withdrawl Transaction";
    }
    public WithdrawTransaction(Transaction transaction) {
        super(transaction.getTransactionDate(),
                transaction.getTransactionAmount(), transaction.getTransactionOwner());
        description = getDescription() + "Withdrawl Transaction";
    }

}
