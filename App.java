import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.LinkedList;
import java.util.Random;
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


        listOfVehicles.put("00-00", new Vehicle("00-00", "Test", "Void", 0, 0));

        listOfVehicles.put("14-E-1234", new Vehicle("14-E-1234", "XL", "Volvo", 6, 2));
        listOfVehicles.put("14-F-1234", new Vehicle("14-F-1234", "Regular", "Toyota", 8, 1));
        listOfVehicles.put("14-D-1234", new Vehicle("14-D-1234", "Regular", "Skoda", 7, 9));
        listOfVehicles.put("14-G-1234", new Vehicle("14-G-1234", "XL", "BMW", 7, 9));
        listOfVehicles.put("14-H-1234", new Vehicle("14-H-1234", "Regular", "Mercedes", 4, 8));


        taxis.insert(new Taxi(listOfVehicles.get("00-00").getX(), listOfVehicles.get("00-00").getY()));

        taxis.insert(new Taxi(listOfVehicles.get("14-E-1234").getX(), listOfVehicles.get("14-E-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-F-1234").getX(), listOfVehicles.get("14-F-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-D-1234").getX(), listOfVehicles.get("14-D-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-G-1234").getX(), listOfVehicles.get("14-G-1234").getY()));
        taxis.insert(new Taxi(listOfVehicles.get("14-H-1234").getX(), listOfVehicles.get("14-H-1234").getY()));


        char[][] mapArray = new char[Map.MAP_SIZE][Map.MAP_SIZE];

        Map map = new Map();

        Customer customer = new Customer("Jim", 'C', 4, 5);

        map.initializeMap();
        mapArray = map.map;
        map.placeOnMap(customer.getX(), customer.getY(), customer.getIcon());

        RequestARide(customer);


        while (!Map.endApp) {

            System.out.println();

//            boolean vehicleNearby = map.searchAdjacentVehicles(mapArray, customer.getX(), customer.getY());
//            while(vehicleNearby){
//                System.out.print("Vehicle found");
//            }
//            while (!vehicleNearby) {

//                System.out.println("No nearby vehicles found. Waiting for a vehicle to arrive...");
            // Wait or delay execution here

            try {
                Thread.sleep(600); // Adjust the delay time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Check for nearby vehicles again
//                map.placeOnMap(customer.getX(), customer.getY(), customer.getIcon());

            mapArray = map.spawnVehicle(mapArray, taxis);


            int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
            int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

            for (int i = 0; i < dx.length; i++) {
                int x = customer.getX();
                int y = customer.getY();

                int newX = x + dx[i];
                int newY = y + dy[i];
//            System.out.println("newx: " +newX);
//            System.out.println("newY: "+ newY);

                // Check if the coordinates are within the map boundaries
                if (isValid(newX, newY, mapArray.length)) {
                    // Check if the square contains a vehicle
                    if (mapArray[newX][newY] == 'V') {
                        System.out.println("CAR FOUND");
                        map.placeOnMap(customer.getX(), customer.getY(), '.');

                        taxi.selectDestination(customer, map);
                        map.printMap();
                         Map.endApp = true;

                    }
                }
            }
            System.out.println("car not found");

            map.printMap();
            map.moveTaxis(taxis, mapArray);
            map.checkBorder(taxis);
            // vehicleNearby = map.searchAdjacentVehicles(mapArray, customer.getX(), customer.getY());
        }

        if (Map.endApp){
            System.out.println("Thank you for using our taxi!");


            System.exit(0);
        }

        // Once a vehicle is nearby, prompt the customer to select a destination
        // taxi.selectDestination(customer);
    }


    //boolean vehicleNearby = map.searchAdjacentVehicles(customer.getX(),customer.getY());
/*
        if (vehicleNearby) {
            RequestARide(customer);
            taxi.selectDestination(customer);
            map.placeOnMap(customer.getX(),customer.getY(),customer.getIcon());
           */

    //    }

/*
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("App Closed.");
*/


    private static void RequestARide(Customer customer) {
        TaxiLogic taxi = new TaxiLogic();

        Map map = new Map();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Request a ride? (y/n)");
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("y")) {
            if (input.equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please enter 'y' to request a ride or 'n' to exit.");
                input = scanner.nextLine();
            }
        }

    }

    private static boolean isValid(int x, int y, int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}



