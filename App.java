import java.util.HashMap;
//import java.util.LinkedList;
import java.util.Random;

public class App {


    private static LinkedList<Location> car;
    private static final char taxiIcon = 'V';

    public App() {

        car = new LinkedList<>();

    }


    public static void main(String[] args) {

        HashMap<String, Vehicle> listOfVehicles = new HashMap<String, Vehicle>();
        TaxiLogic taxi = new TaxiLogic();


        listOfVehicles.put("14-D-1262", new Vehicle("14-D-1262", "Regular", "BMW"));
        listOfVehicles.put("14-E-1234", new Vehicle("14-E-1234", "XL", "Volvo"));

        Map map = new Map();
        Person person = new Person("Jim");
        map.initializeMap();
        map.placeOnMap(4, 5, person.getIcon());

        /* To get the registrations of all cars (keys)
        for (String key : listOfVehicles.keySet()) {
            System.out.println(key);
        }
        */
        Random rand = new Random();

/*
        for (Vehicle vehicle : listOfVehicles.values()) {
            //System.out.println(vehicle.getIcon());
            map.placeOnMap(2,4,vehicle.getIcon());
        }
        map.printMap();

 */
//map.placeOnMap(taxi.getVehicleLocation().getX(), taxi.getVehicleLocation().getY(), 'V');
        // Location point = listOfVehicles.getFirst();

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

            taxi.moveVehicle(direction, map);
        }

            }
        }

