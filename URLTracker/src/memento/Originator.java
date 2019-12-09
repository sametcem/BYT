package memento;

import observer.Observer;
import service.ObserverMapKey;
import memento.Memento;

import java.util.Map;

public class Originator {
    private Map<ObserverMapKey, Observer> state;

    public Map<ObserverMapKey, Observer> getState() {
        return state;
    }

    public void setState(Map<ObserverMapKey, Observer> state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
