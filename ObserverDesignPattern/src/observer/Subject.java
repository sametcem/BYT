package observer;

/*

Observer pattern is used when there is "one-to-many" relationship between objects such as if one object is modified,
its depenedent objects are to be notified automatically. Observer pattern falls under behavioral pattern category.
 */

import java.util.List;
import java.util.ArrayList;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
