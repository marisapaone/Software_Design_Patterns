package paone.cs665.p1;

//Subject interface
public interface AlertSubject {

    public void removeObserver(AlertObserver o);

    public void registerObserver(AlertObserver o);

    public void notifyObservers();
}
