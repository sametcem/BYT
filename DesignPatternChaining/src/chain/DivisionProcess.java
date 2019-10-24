package chain;

public class DivisionProcess implements Chain {

    private Chain nextInChain;

    @Override
    public void setNext(Chain nextChain) {
        nextInChain = nextChain;
    }

    @Override
    public void process(Number req) {
        if(req.getCalculationOp()=="divide"){
            System.out.print(req.getNumber1() + " / " + req.getNumber2() + " = "+
                    (req.getNumber1()/req.getNumber2()));

        } else {
            nextInChain.process(req);
        }
    }
}