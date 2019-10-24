package shopping;

import java.util.ArrayList;

public class AppMediator implements MediatorShopping {
    private ArrayList<Person> people;

    public AppMediator(){
        people = new ArrayList<>();
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    @Override
    public void transact(String message, Person a) {
        for(Person p : people){
            if(p != a) {
                p.receive(message);
            }
        }
    }
}
