package memento;

import observer.Observer;
import service.ObserverMapKey;

import java.io.Serializable;
import java.util.Map;

public class Memento implements Serializable {
    private Map<ObserverMapKey, Observer> state;

    public Memento(Map<ObserverMapKey, Observer> state) {
        this.state = state;
    }

    public Map<ObserverMapKey, Observer> getState() {
        return state;
    }
}
