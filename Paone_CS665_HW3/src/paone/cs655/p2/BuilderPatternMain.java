package paone.cs655.p2;

public class BuilderPatternMain {

    //Main method creates a director instance, a BankOfAmerica user interface builder, and a Chase user interface builder
    //This main method uses Builder Software Design Pattern - the director is creating the UI passing in the builder
    public static void main (String[] args){
        Director director = new Director();
        Builder builder;
        UIProduct product;

        System.out.println("\n...Testing Bank of America UI...\n");
        builder = new BankOfAmericaUIBuilder();
        product = director.createUI(builder);
        product.showProduct();

        System.out.println("\n...Testing Chase UI...\n");
        builder = new ChaseUIBuilder();
        product = director.createUI(builder);
        product.showProduct();
    }
}
