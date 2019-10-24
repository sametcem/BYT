package chain;

public interface Chain {
     void setNext(Chain nextChain);
     void process(Number request);
}
