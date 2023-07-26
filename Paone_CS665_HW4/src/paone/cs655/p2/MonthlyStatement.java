package paone.cs655.p2;

//Leaf class that extends the abstract class Statement. It prints out its description for the Monthly Statements
public class MonthlyStatement extends Statement {


    String name;
    String description;

    public MonthlyStatement (String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName () { return name; }
    public String getDescription() { return description; }

    public void print() {
        System.out.println("**" + getDescription());
    }


}
