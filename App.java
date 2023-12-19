import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.LinkedList;
import java.util.Random;

public class App extends LinkedList<Location> {


    private static LinkedList<Location> car;
    private static final char taxiIcon = 'V';
    public static boolean endApp = false;

    public App() {


    }

    public static void main(String[] args) {

        LinkedList<Taxi> taxis = new LinkedList<>();
        //  LinkedList<Taxi> taxiList = new LinkedList<>();


        HashMap<String, Vehicle> listOfVehicles = new HashMap<String, Vehicle>();
        TaxiLogic taxi = new TaxiLogic();


        listOfVehicles.put("00-00", new Vehicle("00-00", "Test", "Void", 0, 0));

        listOfVehicles.put("14-E-1234", new Vehicle("14-E-1234", "XL", "Volvo", 6, 2));
        listOfVehicles.put("14-F-1234", new Vehicle("14-F-1234", "Regular", "Toyota", 8, 1));
        listOfVehicles.put("14-D-1234", new Vehicle("14-D-1234", "Regular", "Skoda", 7, 9));
        listOfVehicles.put("14-G-1234", new Vehicle("14-G-1234", "XL", "BMW", 7, 9));


        taxis.insert(new Taxi(listOfVehicles.get("00-00").getX(), listOfVehicles.get("00-00").getY()));

        taxis.insert(new Taxi(listOfVehicles.get("14-E-1234").getX(), listOfVehicles.get("14-E-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-F-1234").getX(), listOfVehicles.get("14-F-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-D-1234").getX(), listOfVehicles.get("14-D-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-G-1234").getX(), listOfVehicles.get("14-G-1234").getY()));




        char[][] mapArray = new char[Map.MAP_SIZE][Map.MAP_SIZE];

        Map map = new Map();

        Customer customer = new Customer("Jim", 'C', 4, 5);

        map.initializeMap();



        mapArray = map.map;

        while (!Map.endApp) {
            map.placeOnMap(customer.getX(), customer.getY(), customer.getIcon());

            mapArray = map.spawnVehicle(mapArray, taxis);

            map.printMap();

            map.moveTaxis(taxis,mapArray);
            System.out.println();

            map.checkBorder(taxis);
            boolean vehicleNearby = map.searchAdjacentVehicles(customer.getX(),customer.getY());

        if (vehicleNearby) {


            /*
            *
            *
            * */

        }


            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("App Closed.");


    }
}

