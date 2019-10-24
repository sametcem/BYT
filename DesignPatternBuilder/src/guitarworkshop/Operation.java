package guitarworkshop;

public class Operation {
    public static void main(String[] args) {
        FenderLuthier fenderLuthier = new FenderLuthier();
        GibsonLuthier gibsonLuthier = new GibsonLuthier();

        Producer prod = new Producer(fenderLuthier);
        Producer prod2 = new Producer(gibsonLuthier);

        prod.constructGuitar();
        Guitar guitar1 = prod.getGuitar();
        System.out.println("Guitar is constructed: "+ guitar1);

        prod2.constructGuitar();
        Guitar guitar2 = prod2.getGuitar();
        System.out.println("Guitar is constructed: " + guitar2);

    }
}
