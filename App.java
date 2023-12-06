import java.util.HashMap;
import java.util.Random;

public class App {

    public static void main(String[] args) {

        HashMap<String, Vehicle> listOfVehicles = new HashMap<String, Vehicle>();


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


        for (Vehicle vehicle : listOfVehicles.values()) {
            //System.out.println(vehicle.getIcon());
            map.placeOnMap(2,4,vehicle.getIcon());
        }
        map.printMap();
    }
}
