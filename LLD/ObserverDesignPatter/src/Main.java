import observable.IphoneStockObservable;
import observable.StockObservable;
import observer.NotificationAlertObserver;
import observer.impl.EmailAlertObserverImpl;
import observer.impl.MobileAlertObserverImpl;

public class Main {
    public static void main(String[] args) {

        StockObservable stockObservable = new IphoneStockObservable();
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz@gmail.com", stockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("abc@gmail.com", stockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz_username", stockObservable);


        stockObservable.add(observer1);
        stockObservable.add(observer2);
        stockObservable.add(observer3);

        stockObservable.setStockCount(10);
    }
}