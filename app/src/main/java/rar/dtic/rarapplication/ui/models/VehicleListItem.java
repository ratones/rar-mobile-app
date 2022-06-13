package rar.dtic.rarapplication.ui.models;

public class VehicleListItem {

    private String image;
    private String vin;
    private String civ;

    public VehicleListItem(String image, String vin, String civ) {
        this.image = image;
        this.vin = vin;
        this.civ = civ;
    }

    public String getImage() {
        return image;
    }

    public String getVin() {
        return vin;
    }

    public String getCiv() {
        return civ;
    }
}
