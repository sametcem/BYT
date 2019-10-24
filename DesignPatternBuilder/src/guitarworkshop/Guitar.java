package guitarworkshop;

public class Guitar implements GuitarPlan {
    private String bodyMaterial;
    private String bodyFinish;
    private String neckMaterial;
    private String neckShape;
    private String numberOfFrets;
    private String pickup;
    private String strings;


    @Override
    public void setBodyMaterial(String bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }

    @Override
    public void setBodyFinish(String bodyFinish) {
        this.bodyFinish = bodyFinish;
    }

    @Override
    public void setNeckMaterial(String neckMaterial) {
        this.neckMaterial = neckMaterial;
    }

    @Override
    public void setNeckShape(String neckShape) {
        this.neckShape = neckShape;
    }

    @Override
    public void setNumberOfFrets(String numberOfFrets) {
        this.numberOfFrets = numberOfFrets;
    }

    @Override
    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    @Override
    public void setStrings(String strings) {
        this.strings = strings;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "bodyMaterial='" + bodyMaterial + '\'' +
                ", bodyFinish='" + bodyFinish + '\'' +
                ", neckMaterial='" + neckMaterial + '\'' +
                ", neckShape='" + neckShape + '\'' +
                ", numberOfFrets='" + numberOfFrets + '\'' +
                ", pickup='" + pickup + '\'' +
                ", strings='" + strings + '\'' +
                '}';
    }
}
