package paone.cs655.p1;

import java.util.Date;

//Factory class that implements the interface AccountFactory
public class BankOfAmericaFactory implements AccountFactory {
    @Override
    public CheckingAccount createCheckingAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount) {
        System.out.println("Creating Checking Account");
        return new BankOfAmericaCheckingAccount(primaryOwner, accountId, openDate, initialAmount);
    }

    @Override
    public SavingsAccount createSavingsAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount) {
        System.out.println("Creating Savings Account");
        return new BankOfAmericaSavingsAccount(primaryOwner, accountId, openDate, initialAmount);
    }
}
