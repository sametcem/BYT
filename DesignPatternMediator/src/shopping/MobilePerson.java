package shopping;

public class MobilePerson extends Person {

    public MobilePerson(MediatorShopping mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("Mobile ONLINE Person Received: " + message);
    }
}
