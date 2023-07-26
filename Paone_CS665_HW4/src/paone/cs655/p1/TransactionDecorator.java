package paone.cs655.p1;

import java.util.Date;

//Decorator class that extends the Component class Transaction
public abstract class TransactionDecorator extends Transaction {

    //Creates an Transaction object
    protected Transaction transaction;
    public TransactionDecorator(Date transactionDate, int transactionAmount, Customer transactionOwner) {
        super(transactionDate, transactionAmount, transactionOwner);

    }

}
