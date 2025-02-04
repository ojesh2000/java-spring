package observer.impl;

import observable.GenericObservable;
import observable.impl.CricketScoreStationObservable;
import observable.impl.WeatherStationObservable;
import observer.GenericObserver;

public class MobileObserver implements GenericObserver  {
    public GenericObservable cricketObservable;
    public GenericObservable weatherObservable;

    public MobileObserver(GenericObservable cricketObservable, GenericObservable weatherObservable) {
        this.cricketObservable = cricketObservable;
        this.weatherObservable = weatherObservable;
    }

    @Override
    public void update(Object o) {
        if(o instanceof CricketScoreStationObservable){
            CricketScoreStationObservable cricketScoreStationObservable = (CricketScoreStationObservable) o;
            System.out.println("Updated Cricket Score is: " + cricketScoreStationObservable.getData());
        }else if(o instanceof WeatherStationObservable){
            WeatherStationObservable weatherStationObservable = (WeatherStationObservable) o;
            System.out.println("Updated Weather is: " + weatherStationObservable.getData());
        }else{
            throw new RuntimeException("No valid observer found for the given object");
        }
    }
}
