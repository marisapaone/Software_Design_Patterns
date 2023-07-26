package paone.cs655.p1;

import java.util.Date;

//Interface to implement the abstract factory method - This interface is implemented in BankOfAmericaFactory and ChaseFactory
interface AccountFactory {

    public abstract CheckingAccount createCheckingAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount);
    public abstract SavingsAccount createSavingsAccount(Customer primaryOwner, String accountId, Date openDate, int initialAmount);

}
