package paone.cs655.p1;

import java.util.Date;

//Concrete Decorator class that extends the decorator
public class SecurityDecorator extends TransactionDecorator{

    public SecurityDecorator(Transaction transaction) {
        super(transaction.getTransactionDate(),
                transaction.getTransactionAmount(), transaction.getTransactionOwner());
        this.transaction = transaction;
    }
    @Override
    public String getDescription() {
        return "Security check @" + getTransactionDate() + "->" + transaction.getDescription();
    }
}
