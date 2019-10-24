package guitarworkshop;

public interface GuitarLuthier {
    void buildBodyMaterial();

    void buildBodyFinish();

    void buildNeckMaterial();

    void buildNeckShape();

    void buildNumberOfFrets();

    void buildPickup();

    void buildStrings();

    Guitar getGuitar();
}
