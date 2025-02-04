package observable.impl;

import observable.GenericObservable;
import observer.GenericObserver;
import java.util.List;

public class CricketScoreStationObservable implements GenericObservable {
    public int score;
    public List<GenericObserver> observers;


    public CricketScoreStationObservable(int score, List<GenericObserver> observers) {
        this.score = score;
        this.observers = observers;
    }

    @Override
    public void add(GenericObserver obs) {
        observers.add(obs);
    }

    @Override
    public void remove(GenericObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(GenericObserver obs: observers){
            obs.update(this);
        }
    }

    @Override
    public void updateData(Object obj) {
        if (obj instanceof Integer) {
            this.score = (int) obj;
            notifyObservers();
        } else {
            throw new RuntimeException("Illegal type of data passed in: " + this.getClass());
        }
    }

    @Override
    public Object getData() {
        return this.score;
    }
}