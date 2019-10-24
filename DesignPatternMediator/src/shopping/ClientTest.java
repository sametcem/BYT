package shopping;

public class ClientTest {
    public static void main(String[] args) {
        AppMediator apm = new AppMediator();
        ConcretePerson local_person = new ConcretePerson(apm);
        MobilePerson online_person = new MobilePerson(apm);

        apm.addPerson(local_person);
        apm.addPerson(online_person);

        local_person.sendMoney("10 ZLOTY");
        online_person.sendMoney("67 ZLOTY");
    }
}
