package paone.cs665.p2;

//Strategy Class
public class CompoundMonthly implements InterestCalc{

    double interest;

    public CompoundMonthly(){
        System.out.println("Using Simple Interest");
    }

    //calculate method setting interest variable to the equation, using getters and printing the value
    @Override
    public double calculate(SavingsAccount account) {
        interest = (account.getCurrentBalance()*account.getRate())/12;
        return interest;
    }


}
