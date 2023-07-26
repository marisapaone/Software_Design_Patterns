package paone.cs655.p2;

public class Builder {

    protected static String brandName;
    private UIProduct product;
    //private String brandName;

    public Builder(){
        product = new UIProduct();
        this.brandName = "brand";
    }

    public void createHeader(){
        product.addPart("Creating " + brandName + " Header...");
    }
    public void createSidebar(){
        product.addPart("Creating " + brandName + " Sidebar...");
    }
    public void createMainPanel(){
        product.addPart("Creating " + brandName + " Main Panel...");
    }
    public void createFooter(){
        product.addPart("Creating " + brandName + " Footer...");
    }
    public UIProduct create(){
        return product;
    }
}
