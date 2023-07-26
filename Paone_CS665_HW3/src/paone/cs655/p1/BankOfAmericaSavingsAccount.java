package paone.cs655.p1;

import java.util.Date;

//Concrete class that extends SavingsAccount
public class BankOfAmericaSavingsAccount extends SavingsAccount {
    public BankOfAmericaSavingsAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount) {
        super(primaryOwner, accountId, openDate, initialAmount);
        System.out.println("::Bank of America Savings Account");
    }
}
