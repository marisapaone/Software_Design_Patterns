package paone.cs655.p3;

//InHouseVerifier that implements the common interface and completes its own solution.
public class InHouseVerifier implements IVerify{

    @Override
    public boolean verifyCustomer(Customer customer) {
        System.out.println("Doing In-House verification for " + customer.getName());
        return true;
    }
}
