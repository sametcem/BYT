package shopping;

public abstract class Person {
    private MediatorShopping mediator;

    public Person(MediatorShopping mediator) {
        this.mediator = mediator;
    }

    public MediatorShopping getMediator() {
        return mediator;
    }

    public void setMediator(MediatorShopping mediator) {
        this.mediator = mediator;
    }

    //sending money via the mediator
    public void sendMoney(String message) {
        mediator.transact(message, this);
    }

    //receiving money
    public abstract void receive(String message);

}
