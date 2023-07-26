package paone.cs665.p1;

//Observer concrete class for promotions
public class PromoObserver implements AlertObserver{

    //instantiates a promotional subject object
    private PromotionalSubject promotionalSubject;

    private String observerName;

    //constructor sets the promotional subject to the promo parameter, and registers the observer
    //using "this" alertObserver instance object, and sets the observerName to the name parameter
    public PromoObserver(PromotionalSubject promo, String name) {
        this.promotionalSubject = promo;
        promotionalSubject.registerObserver(this);
        setObserverName(name);
    }

    @Override
    public String update(){
        return "New Products for Auto Loans...";
    };

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

}
