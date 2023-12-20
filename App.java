import java.util.Arrays;
import java.util.HashMap;

import java.util.Scanner;

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

        //Creates new vehicles in the Hash Map
        listOfVehicles.put("00-00", new Vehicle("00-00", "Test", "Void", 0, 0));

        listOfVehicles.put("14-E-1234", new Vehicle("14-E-1234", "XL", "Volvo", 6, 2));
        listOfVehicles.put("14-F-1234", new Vehicle("14-F-1234", "Regular", "Toyota", 8, 1));
        listOfVehicles.put("14-D-1234", new Vehicle("14-D-1234", "Regular", "Skoda", 7, 9));
        listOfVehicles.put("14-G-1234", new Vehicle("14-G-1234", "XL", "BMW", 7, 9));
        listOfVehicles.put("14-H-1234", new Vehicle("14-H-1234", "Regular", "Mercedes", 4, 8));

        //Adds the new vehicles to the linked list
        taxis.insert(new Taxi(listOfVehicles.get("00-00").getX(), listOfVehicles.get("00-00").getY()));

        taxis.insert(new Taxi(listOfVehicles.get("14-E-1234").getX(), listOfVehicles.get("14-E-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-F-1234").getX(), listOfVehicles.get("14-F-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-D-1234").getX(), listOfVehicles.get("14-D-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-G-1234").getX(), listOfVehicles.get("14-G-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-H-1234").getX(), listOfVehicles.get("14-H-1234").getY()));


        char[][] mapArray;

        Map map = new Map();

        //Creates new Customer and defines their location on the map
        Customer customer = new Customer("Jim", 'C', 4, 5);

        //Initialises the blank map of empty spaces
        map.initializeMap();
        mapArray = map.map;
        //Places the customer on the map at it's given coordinates
        map.placeOnMap(customer.getX(), customer.getY(), customer.getIcon());

        //Asks the user if they want to request a ride
        Customer.RequestARide();
//      If user requests a ride the app waits for a taxi to move into nearby range
        while (!Map.endApp) {
            System.out.println();
            try {
                Thread.sleep(600); // Adjust the delay time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Check for nearby vehicles again
//                map.placeOnMap(customer.getX(), customer.getY(), customer.getIcon());

            mapArray = map.spawnVehicle(mapArray, taxis);

//            Until a car enters the area around the customer it prints car not found and the vehicles move again
//            System.out.println("car not found");


            map.printMap();
            map.moveTaxis(taxis, mapArray);
            Vehicle[] taxisInRange = getVehiclesinRange(listOfVehicles, customer, "XL");
            requestARide(taxisInRange, customer);
            map.checkBorder(taxis);

            // vehicleNearby = map.searchAdjacentVehicles(mapArray, customer.getX(), customer.getY());
        }
//        If the users don't request a ride this message is printed and the app closes
        if (Map.endApp) {
            System.out.println("Thank you for using our taxi!");
            System.exit(0);
        }
        // Once a vehicle is nearby, prompt the customer to select a destination
        // taxi.selectDestination(customer);
    }

    private static Vehicle[] getVehiclesinRange(HashMap<String, Vehicle> listOfVehicles, Customer customer, String vehicleType) {


        Vehicle[] vehicleArray = new Vehicle[listOfVehicles.size()];
        int index = 0;
        int radius = getSearchRadius(customer, 2, 10);

        for (Vehicle i : listOfVehicles.values()) {
            // System.out.println("Vehicle found in range:" + i.getX() + " " + i.getY());

            if (i.getX() <= (customer.getX() + radius) && i.getY() <= (customer.getY()) + radius) {
                if (i.getVehicleSize().equals(vehicleType)) {
                    vehicleArray[index] = new Vehicle(i.getReg(), i.getVehicleSize(), i.getVehicleBrand(), i.getX(), i.getY());
                    index++;
                }
            }
        }
       // System.out.println(vehicleArray);
        return vehicleArray;
    }


    private static boolean isValid(int x, int y, int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    public static int getSearchRadius(Customer customer, int r, int size) {

        int radius = 2 * r;
        if (customer.getX() >= radius && customer.getX() < size && customer.getY() >= radius && customer.getY() < size) {

        }
        return 2 * r;
    }

    public static double[] requestARide(Vehicle[] vehicleArray, Customer customer) {

        double[] vehicleDistances = {vehicleArray.length};

        for (int i = 0; i < vehicleArray.length; i++) {
            if (vehicleArray[i] != null) {
                vehicleArray[i].setDistanceToCustomer(distanceToCustomer(customer, vehicleArray[i]));

            }
            Arrays.sort(vehicleDistances);
            double closestVehicle = vehicleDistances[0];

        }
        return vehicleDistances;

    }
          /*
Find vehicles within 2r radius of the current Person location
Put these in an Array
Sort this Array by rank
(this is getVehiclesInRange())
Assign Vehicle to Customer
Remove Vehicle from Map (map[vehicleX][vehicleY]=’.’)
Redraw Map

     */


    public static double distanceToCustomer(Customer customer, Vehicle vehicle) {
        return Math.sqrt(Math.pow(vehicle.getX() - customer.getX(), 2) + Math.pow(vehicle.getY() - customer.getY(), 2));
    }


}





