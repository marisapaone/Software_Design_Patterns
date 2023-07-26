package paone.cs655.p1;

import java.util.Date;

public class UnaffiliatedAccountFactory implements AccountFactory{

    @Override
    public CheckingAccount createCheckingAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount) {
        System.out.println();
        System.out.println("Creating Checking Account");
        return new CheckingAccount(primaryOwner, accountId, openDate, initialAmount);
    }

    @Override
    public SavingsAccount createSavingsAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount) {
        System.out.println();
        System.out.println("Creating Savings Account");
        return new SavingsAccount(primaryOwner, accountId, openDate, initialAmount);
    }
}
