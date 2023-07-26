package paone.cs665.p1;

import java.util.ArrayList;
import java.util.List;

public class PromotionalSubject implements AlertSubject {

    //creates a list of promo observers
    private List<AlertObserver> promoObservers;

    private String promoName = "subject 2";

    //constructor sets the list instantiated as an arraylist of observers
    public PromotionalSubject(){
        promoObservers = new ArrayList<AlertObserver>();
        System.out.println("Promotional info message by " + promoName);
    }

    //removes from observer arraylist
    @Override
    public void removeObserver(AlertObserver o) {
        promoObservers.remove(o);
    }

    //adds to observer arraylist
    @Override
    public void registerObserver(AlertObserver o) {promoObservers.add(o);}

    //iterates through all of the observers in the arraylist to notify each observer
    @Override
    public void notifyObservers() {
        for (AlertObserver observer : promoObservers) {
            System.out.print("Message recieved by " + observer.getObserverName() + " : ");
            System.out.println(observer.update());
        }
    }
}
