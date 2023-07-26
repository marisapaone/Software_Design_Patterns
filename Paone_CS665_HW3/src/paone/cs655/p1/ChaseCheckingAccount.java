package paone.cs655.p1;

import java.util.Date;

//Concrete class that extends CheckingAccount
public class ChaseCheckingAccount extends CheckingAccount{
    public ChaseCheckingAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount) {
        super(primaryOwner, accountId, openDate, initialAmount);
        System.out.println("::Chase Checking Account");
    }
}
