package paone.cs665.p1;

//Observer concrete class for products
public class ProductObserver implements AlertObserver{

    //instantiates a product subject object
    private ProductSubject productSubject;

    private String observerName;

    //constructor sets the product subject to the prodSub parameter, and registers the observer (adds to arraylist)
    //using "this" alertObserver instance object, and sets the observerName to the name parameter
    public ProductObserver(ProductSubject prodSub, String name) {
        this.productSubject = prodSub;
        productSubject.registerObserver(this);
        setObserverName(name);
    }

    @Override
    public String update(){
        return "Interest Rate being increased..." ;
    };

    public String getObserverName() {
        return observerName;
    }
    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

}
