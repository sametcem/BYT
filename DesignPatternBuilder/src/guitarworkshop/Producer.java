package guitarworkshop;

public class Producer {
    private GuitarLuthier guitarLuthier;

    public Producer(GuitarLuthier guitarLuthier) {
        this.guitarLuthier = guitarLuthier;
    }

    public Guitar getGuitar(){
        return this.guitarLuthier.getGuitar();
    }

    public void constructGuitar(){
        this.guitarLuthier.buildBodyMaterial();
        this.guitarLuthier.buildBodyFinish();
        this.guitarLuthier.buildNeckMaterial();
        this.guitarLuthier.buildNeckShape();
        this.guitarLuthier.buildNumberOfFrets();
        this.guitarLuthier.buildPickup();
        this.guitarLuthier.buildStrings();
    }
}
