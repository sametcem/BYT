package chain;

public class Number {
    private int number1;
    private int number2;
    private String calculationOp;

    public Number(int number1,int number2,String calculationOp) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculationOp = calculationOp;
    }
    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }
    public String getCalculationOp(){ return calculationOp; }


}
