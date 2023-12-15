public class Vehicle {
//class for all vehicles
    /*
      registrationNumber = String
    driverName = String
    driverRating = Float (round to 2 places)
    vehicleSize = NORMAL/LARGE/MINIBUS/ACCESSABLE
    vehicleBrand = Volkswagen/Merc/

       */

    private float driverRating;
    private String vehicleSize;
    private String vehicleBrand;
    private String reg;
    private int defaultRating = 1;

    private char icon = 'V';

    public Vehicle(String reg, String vehicleSize, String vehicleBrand) {
        this.driverName = driverName;
        this.vehicleBrand = vehicleBrand;
        this.reg = reg;
        this.driverRating = defaultRating; //all drivers start at rating of 1
        this.icon = icon;

    }

    public char getIcon(){
        return icon;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    private String driverName;

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public float getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(float driverRating) {
        this.driverRating = driverRating;
    }

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize; //this must be only regular, XL or Accessible. change to Enum?
    }


}




