package observable;

import observer.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver obs);
    void remove(NotificationAlertObserver obs);
    void notifySubscriber();
    void setStockCount(int newStockCount);
    int getStockCount();

}
