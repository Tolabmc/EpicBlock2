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
    private float defaultRating = 1;

    private int X;

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    private int Y;

    public int getY(){
        return Y;

    }

    private double distanceToCustomer;

    public void setY(int Y){
        Y =Y;
    }

    private char icon = 'V';

    public float getDefaultRating() {
        return defaultRating;
    }

    public void setDefaultRating(float defaultRating) {
        this.defaultRating = defaultRating;
    }

    public double getDistanceToCustomer() {
        return distanceToCustomer;
    }

    public void setDistanceToCustomer(double distanceToCustomer) {
        this.distanceToCustomer = distanceToCustomer;
    }

    public void setIcon(char icon) {
        this.icon = icon;
    }

    public Vehicle(String reg, String vehicleSize, String vehicleBrand, int X, int Y) {
        this.driverName = driverName;
        this.vehicleBrand = vehicleBrand;
        this.reg = reg;
        this.driverRating = defaultRating; //all drivers start at rating of 1
        this.icon = icon;
        this.X = X;
        this.Y = Y;
        this.vehicleSize = vehicleSize;
        this.distanceToCustomer = 100;
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




