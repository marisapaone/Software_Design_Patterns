package paone.cs655.p1;

import java.util.Date;

//Concrete class that extends CheckingAccount
public class BankOfAmericaCheckingAccount  extends CheckingAccount {
    public BankOfAmericaCheckingAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount) {
        super(primaryOwner, accountId, openDate, initialAmount);
        System.out.println("::Bank of America Checking Account");
    }

}
