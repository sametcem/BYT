package app;
import observer.PJATKObserver;
import service.Monitor;
import memento.Originator;
import memento.CareTaker;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        URL pjatk = new URL("http://www.pja.edu.pl/");

        Monitor monitor = new Monitor();

        PJATKObserver pjObserver = new PJATKObserver(monitor, pjatk);

        monitor.addToObserversMap(pjObserver);

        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator();

        new GUI(monitor, originator, careTaker);

    }

}
