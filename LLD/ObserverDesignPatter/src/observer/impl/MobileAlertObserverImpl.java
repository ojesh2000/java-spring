package observer.impl;

import observable.StockObservable;
import observer.NotificationAlertObserver;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    public String userName;
    public StockObservable stockObservable;

    public MobileAlertObserverImpl(String userName, StockObservable stockObservable){
        this.userName = userName;
        this.stockObservable = stockObservable;
    }


    @Override
    public void update() {
        System.out.println("Mobile Alert sent to: " + userName + " Stock count is: " + stockObservable.getStockCount());
    }
}
