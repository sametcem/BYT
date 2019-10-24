package shopping;

public class ConcretePerson extends Person {

    public ConcretePerson(MediatorShopping mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("Concerete LOCAL Person Received: " + message);
    }
}
