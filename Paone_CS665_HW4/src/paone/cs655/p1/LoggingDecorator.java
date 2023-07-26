package paone.cs655.p1;


//Concrete Decorator class that extends the decorator
public class LoggingDecorator extends TransactionDecorator{

    public LoggingDecorator(Transaction transaction) {
        super(transaction.getTransactionDate(),
                transaction.getTransactionAmount(), transaction.getTransactionOwner());
        this.transaction = transaction;
    }

    @Override
    public String getDescription() {
        return "Logging @" + getTransactionDate() + "->" + transaction.getDescription();
    }
}
