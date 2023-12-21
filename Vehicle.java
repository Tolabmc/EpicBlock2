public class Vehicle {
//class for all vehicles
    /*
      registrationNumber = String
    driverName = String
    driverRating = Float (round to 2 places)
    vehicleSize = NORMAL/LARGE/MINIBUS/ACCESSABLE
    vehicleBrand = Volkswagen/Merc/

       */

    private int driverRating;
    private String vehicleSize;
    private String vehicleBrand;
    private String reg;
    private int defaultRating = 1;

    private int X;


    private double distanceToCustomer;



    private char icon = 'V';



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


    public int getX() {
        return X;
    }

    public int setX(int x) {
        X = x;
        return x;
    }

    private int Y;

    public int getY(){
        return Y;

    }
    public int setY(int Y){
        Y =Y;
        return Y;
    }

    public double getDistanceToCustomer() {
        return distanceToCustomer;
    }

    public void setDistanceToCustomer(double distanceToCustomer) {
        this.distanceToCustomer = distanceToCustomer;
    }

    public char setIcon(char icon) {
        this.icon = icon;
        return icon;
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

    public int getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize; //this must be only regular, XL or Accessible. change to Enum?
    }


}




