package paone.cs655.p3;

//ABCValidator is an adaptee class. ABCAdapter is its adapter class
public class ABCValidator {

    public static boolean validate(String name, String number){
        System.out.println("ABC third party verification for " + name + ", " + number);
        return true;
    }


}
