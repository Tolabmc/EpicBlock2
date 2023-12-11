import java.util.HashMap;
import java.util.LinkedList;
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
        // Random num = new Random(Integer);

/*
        for (Vehicle vehicle : listOfVehicles.values()) {
            //System.out.println(vehicle.getIcon());
            map.placeOnMap(2,4,vehicle.getIcon());
        }
        map.printMap();

 */
//map.placeOnMap(taxi.getVehicleLocation().getX(), taxi.getVehicleLocation().getY(), 'V');
        // Location point = listOfVehicles.getFirst();


        Location Newpoint = new Location(taxi.getVehicleLocation().getX(), taxi.getVehicleLocation().getY());


        //  for (Vehicle vehicle : listOfVehicles.values()) {
        //System.out.println(vehicle.getIcon());
        //map.placeOnMap(2, 4, vehicle.getIcon());

        // }
       /* for (int i = 0; i <= 5; i++) {
            map.printMap();
            System.out.println();
            Direction direction = Direction.RANDOM;
            taxi.moveVehicle(direction, map);




            //taxi.getVehicleLocation().getX() >= 0 && taxi.getVehicleLocation().getX() < map.MAP_SIZE && taxi.getVehicleLocation().getY() >= 0 && taxi.getVehicleLocation().getY() < map.MAP_SIZE
        }

        */
        Random rand = new Random();
        for (int i = 0; i <= 50; i++) {
            map.printMap();
            System.out.println();

            // Perform a random move
            Direction direction = Direction.RANDOM;
            taxi.moveVehicle(direction, map);

            // Wait for a short time (simulating some action)
            try {
                Thread.sleep(1000); // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Choose a new random direction for the next move
            direction = Direction.values()[rand.nextInt(Direction.values().length)];
            taxi.moveVehicle(direction, map);
        }
    }
}

