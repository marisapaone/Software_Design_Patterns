package paone.cs655.p1;

import java.util.Date;

//Concrete class that extends SavingsAccount
public class ChaseSavingsAccount extends SavingsAccount{

    public ChaseSavingsAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount) {
        super(primaryOwner, accountId, openDate, initialAmount);
        System.out.println("::Chase Savings Account");
    }
}
