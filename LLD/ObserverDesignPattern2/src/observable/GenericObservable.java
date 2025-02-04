package observable;

import observer.GenericObserver;

public interface GenericObservable {
    public void add(GenericObserver obs);
    public void remove(GenericObserver obs);
    public void notifyObservers();
    public void updateData(Object obj);
    public Object getData();
}
