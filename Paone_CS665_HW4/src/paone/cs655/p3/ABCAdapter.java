package paone.cs655.p3;

//ABCAdapter class is an adapter that implements the IVerify interface and allows ABCValidator and XYZChecker to be
//translated to use IVerify.
public class ABCAdapter implements IVerify{

    ABCValidator abcValidator;
    XYZChecker xyzChecker;

    public ABCAdapter (ABCValidator abcValidator){
        this.abcValidator = abcValidator;
    }
    public ABCAdapter (XYZChecker xyzChecker){
        this.xyzChecker = xyzChecker;
    }

    //Overrides verifyCustomer from IVerify interface... utilizes abcValidator validate method
    //and xyzChecker backgroundCheck method with the customers specific parameters.
    @Override
    public boolean verifyCustomer(Customer customer) {
        if (abcValidator.validate(customer.getName(), customer.getNumber()) &&
                xyzChecker.backgroundCheck(customer.getName(), customer.getAddress())){
            return true;
        }
        else{
            return false;
        }
    }


}
