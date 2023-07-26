package paone.cs655.p2;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.Iterator;

//Composite class that implements the lead related operations and defines the behavior of the components (quarters, half yearly, full yearly)
//Stores statements in an arraylist, uses an iterator to print out each one
public class ComboStatement extends Statement {

    ArrayList<Statement> statementComponents = new ArrayList<Statement>();
    String name;
    String description;

    public ComboStatement (String name, String description){
        this.name = name;
        this.description = description;
    }

    public void add(Statement statement) {
        statementComponents.add(statement);
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {

        System.out.println("**" + getDescription());


        Iterator<Statement> iterator = statementComponents.iterator();
        while (iterator.hasNext()) {
            Statement statement =
                    (Statement)iterator.next();
            statement.print();
        }
    }

}
