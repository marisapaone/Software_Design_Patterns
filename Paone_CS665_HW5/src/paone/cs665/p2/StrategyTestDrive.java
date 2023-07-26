package paone.cs665.p2;

//main method for the strategy pattern
public class StrategyTestDrive {

    public static void main (String args[]){

        //creating the context object
        SavingsAccount strat1 = new SavingsAccount();
        //setting the context strategy to simple interest
        strat1.setStrategy(new CompoundMonthly());

        //setting the rate and current balance
        strat1.setRate(0.02);
        strat1.setCurrentBalance(1000000);

        //telling the context strategy to calculate interest
        strat1.calculateStrategy();

        //creating a second context object
        SavingsAccount strat2 = new SavingsAccount();
        //setting the context strategy to compound interest
        strat2.setStrategy(new CompoundDaily());

        //setting rate and current balance
        strat2.setRate(0.02);
        strat2.setCurrentBalance(1000000);

        //telling the context to calculate interest
        strat2.calculateStrategy();

    }
}
