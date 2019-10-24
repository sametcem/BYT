package chain;

// DESIGN PATTERN CHAIN
public class TestChain {
    public static void main(String[] args) {
        //configure Chain of Responsibility
        Chain c1 = new AddProcess();
        Chain c2 = new MinusProcess();
        Chain c3 = new MultProcess();
        Chain c4 = new DivisionProcess();

        c1.setNext(c2);
        c2.setNext(c3);
        c3.setNext(c4);

        Number request = new Number(160,8,"divide");

        c1.process(request);

    }
}
