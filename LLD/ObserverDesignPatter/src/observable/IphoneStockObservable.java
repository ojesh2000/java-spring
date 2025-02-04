package observable;

import observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements StockObservable {
    private List<NotificationAlertObserver> observers = new ArrayList<NotificationAlertObserver>();
    public int stockCount = 0;


    @Override
    public void add(NotificationAlertObserver obs) {
        observers.add(obs);
    }

    @Override
    public void remove(NotificationAlertObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notifySubscriber() {
        for(NotificationAlertObserver obs: observers){
            obs.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        this.stockCount = newStockCount;
        notifySubscriber();
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
