package paone.cs665.p1;

import java.util.ArrayList;
import java.util.List;

//Subject concrete class
public class ProductSubject implements AlertSubject{

    //creates a list of product observers
    private List<AlertObserver> productObservers;

    private String productName = "subject 1";

    //constructor sets the list instantiated as an arraylist of observers
    public ProductSubject (){
        productObservers = new ArrayList<AlertObserver>();
        System.out.println("Product Info Message by " + productName);
    }

    //removes object from arraylist
    @Override
    public void removeObserver(AlertObserver o) {
        productObservers.remove(o);
    }

    //adds to the arraylist
    @Override
    public void registerObserver(AlertObserver o) {
        productObservers.add(o);
    }

    //iterates through all of the observers in the arraylist to notify each observer
    @Override
    public void notifyObservers() {

        for (AlertObserver observer : productObservers) {
            System.out.print("Message received by " + observer.getObserverName() + " : ");
            System.out.println(observer.update());
        }

    }
}
