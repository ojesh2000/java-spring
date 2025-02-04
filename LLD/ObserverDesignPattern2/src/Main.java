import observable.GenericObservable;
import observable.impl.CricketScoreStationObservable;
import observer.GenericObserver;
import observer.impl.LaptopObserver;
import observer.impl.MobileObserver;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GenericObservable cricketObservable = new CricketScoreStationObservable(0, new ArrayList<>());
        GenericObservable weatherObservable = new CricketScoreStationObservable(0, new ArrayList<>());

        GenericObserver obs1 = new LaptopObserver(cricketObservable, weatherObservable);
        GenericObserver obs2 = new LaptopObserver(cricketObservable, weatherObservable);
        GenericObserver obs3 = new MobileObserver(cricketObservable, weatherObservable);

        cricketObservable.add(obs1);
        cricketObservable.add(obs2);
        cricketObservable.add(obs3);


        weatherObservable.add(obs1);
        weatherObservable.add(obs2);
        weatherObservable.add(obs3);

        cricketObservable.updateData(100);
        weatherObservable.updateData(16);

    }
}