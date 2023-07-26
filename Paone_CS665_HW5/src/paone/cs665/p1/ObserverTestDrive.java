package paone.cs665.p1;

//main method for the observer pattern
public class ObserverTestDrive {

    public static void main (String args[]){

        //creating a product subject object
        ProductSubject product = new ProductSubject();

        //creating product observer objects and calling notifyObservers on the product subject object
        ProductObserver charlie = new ProductObserver(product,"Charlie");
        ProductObserver dave = new ProductObserver(product, "Dave");
        product.notifyObservers();

        //creating a promotional subject object
        PromotionalSubject promo = new PromotionalSubject();

        //creating promo observer objects and calling notifyObservers on the promotional subject object
        PromoObserver alice = new PromoObserver(promo, "Alice");
        PromoObserver bob = new PromoObserver(promo, "Bob");
        promo.notifyObservers();





    }
}
