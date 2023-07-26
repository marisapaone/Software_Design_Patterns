package paone.cs665.p2;

public class CompoundDaily implements InterestCalc{

    double interest;

    public CompoundDaily(){
        System.out.println("Using Compound Interest");
    }

    //calculate method setting interest variable to the equation, using getters and printing the value
    @Override
    public double calculate(SavingsAccount account) {
        interest = (account.getCurrentBalance()*Math.pow((1 + (account.getRate()/365) ), 31)) - account.getCurrentBalance();
        return interest;
    }
}
