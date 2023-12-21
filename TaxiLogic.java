import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class TaxiLogic {
    Map map = new Map();

    public void completeRide(Vehicle vehicle, HashMap<String, Vehicle> listOfVehicles, Customer customer) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Leave a review: /5 "); //Prompt Person for driver rating

        int input = scanner.nextInt();
        listOfVehicles.get(vehicle.getReg()).setDriverRating(input);
        map.placeOnMap(listOfVehicles.get(vehicle.getReg()).getX(), listOfVehicles.get(vehicle.getReg()).getY(), vehicle.getIcon());
        System.out.println("Thank you for driving with us!");

    }

    public int[] selectDestination(Customer customer, Map map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your destination:\n X:\n");
        int XInput = scanner.nextInt();
        System.out.println("Y:");
        int YInput = scanner.nextInt();

        customer.setX(XInput);
        customer.setY(YInput);
        customer.setIcon('C');

        map.placeOnMap(XInput, YInput, 'C');

        return new int[] {XInput, YInput};
    }

    public static boolean isVehicleInRange(Vehicle[] subSetArray) {

        return subSetArray.length > 0;
    }

    static Vehicle[] getVehiclesinRange(HashMap<String, Vehicle> listOfVehicles, Customer customer, String vehicleType, int r) {

        Vehicle[] vehicleArray = new Vehicle[listOfVehicles.size()];
        int index = 0;

        for (Vehicle i : listOfVehicles.values()) {
            double distance = distanceToCustomer(customer, i);
            double radius = 2 * r;

            if (distance <= radius && i.getVehicleSize().equals(vehicleType)) { //if the distance is less than or equal to 2 * r, then those specific vehicles are contacted

                vehicleArray[index] = new Vehicle(i.getReg(), i.getVehicleSize(), i.getVehicleBrand(), i.getX(), i.getY());
                vehicleArray[index].setDistanceToCustomer(distance);
                index++;
            }
        }
        //this array is a subset of all vehicles containing the desired vehicle type
        Vehicle[] subSetArray = Arrays.copyOf(vehicleArray, index); //the index determines the size of the subset we want

        // this sorts the subset array by the calculated distance to the customer using a lambda function
        Arrays.sort(subSetArray, (a, b) -> Double.compare(a.getDistanceToCustomer(), b.getDistanceToCustomer()));
        return subSetArray;
    }

    public static Vehicle requestARide(Vehicle[] vehicleArray, Customer customer) {

        Map map = new Map();
        TaxiLogic taxi = new TaxiLogic();

        Vehicle closestVehicle = vehicleArray[0];

        //this gets the x and y coOrd of the vehicle and sets it to the EMPTY icon
        map.placeOnMap(closestVehicle.getX(), closestVehicle.getY(), closestVehicle.setIcon(Map.EMPTY));

        //this sets the x and y coOrd of the vehicle to wherever the customer is
        map.placeOnMap(closestVehicle.setX(customer.getX()), closestVehicle.setY(customer.getY()), closestVehicle.setIcon(Map.EMPTY));

        map.placeOnMap(customer.getX(), customer.getY(), customer.setIcon(Map.EMPTY));
        System.out.println("Customer picked up");

        return closestVehicle;
    }

    public static double distanceToCustomer(Customer customer, Vehicle vehicle) {
        return Math.sqrt(Math.pow(vehicle.getX() - customer.getX(), 2) + Math.pow(vehicle.getY() - customer.getY(), 2));
    }

}