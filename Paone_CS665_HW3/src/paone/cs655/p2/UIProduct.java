package paone.cs655.p2;

import java.util.ArrayList;
import java.util.List;

public class UIProduct {
    private List<String> userInterfaceParts;

    public UIProduct(){
        userInterfaceParts = new ArrayList<>();
    }
    public void addPart(String description){
        userInterfaceParts.add(description);
    }
    public void showProduct(){

        System.out.println("User interface completed as below :");

        for (int i = 0; i < userInterfaceParts.size(); i++){
            System.out.println("Step "+ (i+1) + ": " + userInterfaceParts.get(i));
        }
    }

}
