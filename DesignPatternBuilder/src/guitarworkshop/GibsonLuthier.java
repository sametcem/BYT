package guitarworkshop;

public class GibsonLuthier implements GuitarLuthier {
    private Guitar guitar;

    public GibsonLuthier(){
        this.guitar = new Guitar();
    }

    @Override
    public void buildBodyMaterial() {
        guitar.setBodyMaterial("2-Piece Plain Maple, Hide Glue Fit");
    }

    @Override
    public void buildBodyFinish() {
        guitar.setBodyFinish("Polyurethane");
    }

    @Override
    public void buildNeckMaterial() {
        guitar.setNeckMaterial("Solid Mahogany");
    }

    @Override
    public void buildNeckShape() {
        guitar.setNeckShape("Chunky C-Shape");
    }

    @Override
    public void buildNumberOfFrets() {
        guitar.setNumberOfFrets("24 ABANOSE");
    }

    @Override
    public void buildPickup() {
        guitar.setPickup("Custombucker Alnico III (Unpotted)");
    }

    @Override
    public void buildStrings() {
        guitar.setStrings("Gibson Custom Switchplate Medallion");
    }

    @Override
    public Guitar getGuitar() {
        return this.guitar;
    }
}
