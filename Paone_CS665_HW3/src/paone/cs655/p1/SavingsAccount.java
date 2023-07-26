package paone.cs655.p1;

import java.util.Date;

class SavingsAccount extends Account {

    public SavingsAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount) {
        super(primaryOwner, accountId, openDate);
        Transaction t = new DepositTransaction(openDate, initialAmount, primaryOwner, this);
        System.out.print("**Basic Savings Account**");
    }

}
