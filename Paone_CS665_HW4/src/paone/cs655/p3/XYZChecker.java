package paone.cs655.p3;

//XYZChecker is an adaptee class. ABCAdapter is its adapter class
public class XYZChecker {

    public static boolean backgroundCheck(String name, String address){
        System.out.println("XYZ third party background check for " + name + ", " + address);
        return true;
    }


}
