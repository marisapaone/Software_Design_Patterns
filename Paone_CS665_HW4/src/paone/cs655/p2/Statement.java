package paone.cs655.p2;

//Abstract Statement class to define the methods for ComboStatment class and MonthlyStatement Class
public abstract class Statement {

    public void add(Statement statement){
        throw new UnsupportedOperationException();
    }
    public String getDescription(){
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

}
