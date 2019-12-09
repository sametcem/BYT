package memento;

import java.io.*;

public class CareTaker {
    private String fileName = "memento.txt";

    public void add(Memento state) {
        File file = new File(fileName);
        FileOutputStream f = null;
        try {
            f = new FileOutputStream(file);
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(state);
            s.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Memento get() {
        File file = new File(fileName);
        FileInputStream f = null;
        Memento m = null;
        try {
            f = new FileInputStream(file);
            ObjectInputStream s = new ObjectInputStream(f);
            m = (Memento) s.readObject();
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return m;
    }
}

