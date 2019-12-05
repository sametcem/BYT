package memento;

/*

    Memento pattern is used to restore state of an object to a previous state. Memento pattern falls under behavioral pattern category.

    Memento pattern uses three actor classes. Memento contains state of an object to be restored.
    Originator creates and stores states in Memento objects and Caretaker object is responsible to restore object state from Memento.
     We have created classes Memento, Originator and CareTaker.
    MementoPatternDemo, our demo class, will use CareTaker and Originator objects to show restoration of object states.
*/

public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState(){
        return state;
    }

}
