import java.util.Arrays;
import java.util.HashMap;

import java.util.Scanner;

public class App {

    public static boolean endApp = false;

    public App() {
    }

    public static void main(String[] args) {

        LinkedList<Taxi> taxis = new LinkedList<>();
        HashMap<String, Vehicle> listOfVehicles = new HashMap<String, Vehicle>();
        TaxiLogic taxi = new TaxiLogic();

        //Creates new vehicles in the Hash Map
        listOfVehicles.put("00-00", new Vehicle("00-00", "Test", "Void", 0, 0));

        listOfVehicles.put("14-E-1234", new Vehicle("14-E-1234", "XL", "Volvo", 9, 9));
        listOfVehicles.put("14-F-1234", new Vehicle("14-F-1234", "Regular", "Toyota", 8, 1));
        listOfVehicles.put("14-D-1234", new Vehicle("14-D-1234", "Regular", "Skoda", 4, 0));
        listOfVehicles.put("14-G-1234", new Vehicle("14-G-1234", "XL", "BMW", 7, 9));
        listOfVehicles.put("14-H-1234", new Vehicle("14-H-1234", "Regular", "Mercedes", 1, 8));

        //Adds the new vehicles to the linked list
        taxis.insert(new Taxi(listOfVehicles.get("00-00").getX(), listOfVehicles.get("00-00").getY(), listOfVehicles.get("00-00").getReg()));

        taxis.insert(new Taxi(listOfVehicles.get("14-E-1234").getX(), listOfVehicles.get("14-E-1234").getY(), listOfVehicles.get("14-E-1234").getReg()));
        taxis.insert(new Taxi(listOfVehicles.get("14-F-1234").getX(), listOfVehicles.get("14-F-1234").getY(), listOfVehicles.get("14-F-1234").getReg()));
        taxis.insert(new Taxi(listOfVehicles.get("14-D-1234").getX(), listOfVehicles.get("14-D-1234").getY(), listOfVehicles.get("14-D-1234").getReg()));
        taxis.insert(new Taxi(listOfVehicles.get("14-G-1234").getX(), listOfVehicles.get("14-G-1234").getY(), listOfVehicles.get("14-G-1234").getReg()));
        taxis.insert(new Taxi(listOfVehicles.get("14-H-1234").getX(), listOfVehicles.get("14-H-1234").getY(), listOfVehicles.get("14-H-1234").getReg()));

        Map map = new Map();
        Customer customer = new Customer("Jim", 'C', 4, 5);  //Creates new Customer and defines their location on the map

        map.initializeMap(); //Initialises the blank map of empty spaces
        map.placeOnMap(customer.getX(), customer.getY(), customer.getIcon()); //Places the customer on the map at it's given coordinates
        map.printMap();

        Customer.startMessage();  //Asks the user if they want to request a ride
        String requestedTaxiType = customer.requestTaxiType();
//      If user requests a ride the app waits for a taxi to move into nearby range


        while (!Map.endApp) {
            System.out.println();
            try {
                Thread.sleep(500); // pauses before running the loop again


                map.spawnVehicle(map, taxis); //spawns taxis from mapArray
                map.printMap();
                map.moveTaxis(taxis, map, listOfVehicles); //moves all taxis in a random direction
                map.placeOnMap(customer.getX(), customer.getY(), customer.getIcon()); //redraw customer if vehicle is in their coOrd

                map.checkBorder(taxis); //makes sure all taxis remain within the map

                Vehicle[] taxisInRange = taxi.getVehiclesinRange(listOfVehicles, customer, requestedTaxiType, 2);

                System.out.println();

                if (taxi.isVehicleInRange(taxisInRange)) { //boolean value to get whether there is the appropriate taxi in range
                    Vehicle chosenTaxi = taxi.requestARide(taxisInRange, customer);
                    int[] selectedCoOrds = taxi.selectDestination(customer, map);
                    int selectedX = selectedCoOrds[0]; //first value in array (X)
                    int selectedY = selectedCoOrds[1]; //second value in array (Y)

                    System.out.println("Driving...");
                    Thread.sleep(1000);

                    map.initializeMap();
                    map.placeOnMap(selectedX, selectedY, customer.getIcon());
                    map.printMap();
                    taxi.completeRide(chosenTaxi, listOfVehicles, customer);
                    Customer.startMessage();  //Asks the user if they want to request a ride
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        If the users don't request a ride this message is printed and the app closes
        if (Map.endApp) {
            System.out.println("Thank you for using our taxi!");
            System.exit(0);
        }

    }

}
