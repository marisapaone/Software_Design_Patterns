package paone.cs665.p2;

//Strategy Interface with one method - calculate that takes in a SavingsAccount as a parameter
public interface InterestCalc {

    public double calculate(SavingsAccount account);
}
