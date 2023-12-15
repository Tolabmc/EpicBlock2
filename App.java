import java.util.HashMap;
//import java.util.LinkedList;
import java.util.LinkedList;
import java.util.Random;

public class App {


    private static LinkedList<Location> car;
    private static final char taxiIcon = 'V';
    public static boolean endApp = false;

    public App() {



    }

    public static void main(String[] args) {


        HashMap<String, Vehicle> listOfVehicles = new HashMap<String, Vehicle>();
        TaxiLogic taxi = new TaxiLogic();
        LinkedList<Taxi> taxis = new LinkedList<>();

        taxis.add(new Taxi(3, 5));
        taxis.add(new Taxi(6, 2));


        listOfVehicles.put("14-D-1262", new Vehicle("14-D-1262", "Regular", "BMW"));
        listOfVehicles.put("14-E-1234", new Vehicle("14-E-1234", "XL", "Volvo"));

        char[][] map = new char[Map.MAP_SIZE][Map.MAP_SIZE];
        Map map1 = new Map();
        //map1.placePerson();


       Person person = new Person("Jim", 'P', 4, 5);
        map1.placeOnMap(person.getXcoOrd(),person.getYcoOrd(), person.getIcon());


        /*
        To get the registrations of all cars (keys)
        for (String key : listOfVehicles.keySet()) {
            System.out.println(key);
        }
        */
        Random rand = new Random();

        while (!endApp) {

            map1.printMap(map, taxis);
            map1.moveTaxis(taxis, rand);
            map1.checkBorder(taxis);

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
