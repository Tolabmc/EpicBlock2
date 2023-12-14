public class TaxiDriver extends Person{
private boolean availiability;
    public TaxiDriver(String name, char icon, int XcoOrd, int YcoOrd, boolean availiability) {
        super(name, icon, XcoOrd, YcoOrd);

        this.availiability = availiability;
    }
    public void acceptRide(){
        availiability = false;
        

    }

}
