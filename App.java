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

        taxis.insert(new Taxi(3, 5));
        taxis.insert(new Taxi(6, 2));
        taxis.insert(new Taxi(1, 2));
        taxis.insert(new Taxi(7, 9));
        taxis.insert(new Taxi(5, 1));


/*
        taxis.add(new Taxi(3, 5));
        taxis.add(new Taxi(6, 2));
*/

        listOfVehicles.put("14-D-1262", new Vehicle("14-D-1262", "Regular", "BMW", 3, 5));
        listOfVehicles.put("14-E-1234", new Vehicle("14-E-1234", "XL", "Volvo", 6, 2));

        char[][] mapArray = new char[Map.MAP_SIZE][Map.MAP_SIZE];

        Map map = new Map();
        //map1.placePerson();

        Customer customer = new Customer("Jim", 'C', 4, 5);
//        map1.placeOnMap(customer.getX(),customer.getY(), customer.getIcon());
//        map[customer.getX()][customer.getY()] = customer.getIcon();

        /*
        To get the registrations of all cars (keys)
        for (String key : listOfVehicles.keySet()) {
            System.out.println(key);
        }
        */


        map.initializeMap();



        mapArray = map.map;

        while (!Map.endApp) {
            map.placeOnMap(customer.getX(), customer.getY(), customer.getIcon());

            mapArray = map.spawnVehicle(mapArray, taxis);

            map.printMap();

            map.moveTaxis(taxis,mapArray);
            System.out.println();

            map.checkBorder(taxis);


            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("App Closed.");
/*
        for (Vehicle vehicle : listOfVehicles.values()) {
            //System.out.println(vehicle.getIcon());
            map.placeOnMap(2,4,vehicle.getIcon());
        }
        map.printMap();

 */
//map.placeOnMap(taxi.getVehicleLocation().getX(), taxi.getVehicleLocation().getY(), 'V');
        // Location point = listOfVehicles.getFirst();
/*
        Location NewPoint = new Location(taxi.getVehicleLocation().getX(),taxi.getVehicleLocation().getY());
        Direction direction = Direction.RIGHT;

        //  for (Vehicle vehicle : listOfVehicles.values()) {
        //System.out.println(vehicle.getIcon());
        //map.placeOnMap(2, 4, vehicle.getIcon());

        // }

        for (int i=0; i <= 7; i++) {
            // while (true) {
            map.printMap();
            System.out.println();
            /*
            if (taxi.getVehicleLocation().getX() >= 10)  {
               direction = Direction.LEFT;
            }
            if (taxi.getVehicleLocation().getX() <= 0)  {
                direction = Direction.RIGHT;
            }
            if (taxi.getVehicleLocation().getY() >= 10)  {
                direction = Direction.UP;
            }
            if (taxi.getVehicleLocation().getY() <= 0)  {
                direction = Direction.DOWN;
            }
             */
/*
            taxi.moveVehicle(direction, map);
                }


            }
        }
*/
    }
}
