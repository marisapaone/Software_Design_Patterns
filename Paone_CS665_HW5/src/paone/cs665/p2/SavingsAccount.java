package paone.cs665.p2;

// Context/Subject Class
public class SavingsAccount {

    //instantiating an instance of the strategy interface
    InterestCalc interestCalc;

    private int currentBalance;

    private double rate;

    //strategy method to calculate either strategies and print what it returns
    public void calculateStrategy(){
        System.out.println(interestCalc.calculate(this));
    }

    //getters and setters
    public int getCurrentBalance(){return this.currentBalance;}

    public void setStrategy (InterestCalc interestCalc){
        this.interestCalc = interestCalc;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getRate(){ return this.rate; }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
