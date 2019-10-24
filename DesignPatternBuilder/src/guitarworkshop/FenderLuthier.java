package guitarworkshop;

public class FenderLuthier implements GuitarLuthier {
    private Guitar guitar;

    public FenderLuthier() {
        this.guitar = new Guitar();
    }

    @Override
    public void buildBodyMaterial() {
        guitar.setBodyMaterial("Alder");
    }

    @Override
    public void buildBodyFinish() {
        guitar.setBodyFinish("Gloss Nitrocellulose Lacquer");
    }

    @Override
    public void buildNeckMaterial() {
        guitar.setNeckMaterial("Maple");
    }

    @Override
    public void buildNeckShape() {
        guitar.setNeckShape("Soft-V");
    }

    @Override
    public void buildNumberOfFrets() {
        guitar.setNumberOfFrets("22 DOTS");
    }

    @Override
    public void buildPickup() {
        guitar.setPickup("DiMarzio® AREA 61");
    }

    @Override
    public void buildStrings() {
        guitar.setStrings("Fender® USA 250L Nickel Plated Steel");
    }

    @Override
    public Guitar getGuitar() {
        return this.guitar;
    }
}
