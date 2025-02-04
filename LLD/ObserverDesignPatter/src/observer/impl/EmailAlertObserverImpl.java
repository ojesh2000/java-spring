package observer.impl;

import observable.StockObservable;
import observer.NotificationAlertObserver;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    public String mailId;
    public StockObservable stockObservable;

    public EmailAlertObserverImpl(String mailId, StockObservable stockObservable){
        this.mailId = mailId;
        this.stockObservable = stockObservable;
    }


    @Override
    public void update() {
        System.out.println("Email sent to: " + mailId + " Stock count is: " + stockObservable.getStockCount());
    }
}
