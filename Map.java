
import java.util.HashMap;
import java.util.Random;

public class Map {

    public static boolean endApp = false;
    private Customer customer;
    public static final int MAP_SIZE = 10;
    public static final char EMPTY = '.';
    public static final char VehicleChar = 'V';


    public char[][] map;


    public Map() {
        this.map = new char[MAP_SIZE][MAP_SIZE];

    }

    //  The intitialise map function sets each char to an empty dot to create the empty map
    public void initializeMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY;
            }
        }
    }


    //  The print Map function is called in app to print the mapArray which allows the customers and vehicles to be placed
    public void printMap() {

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    public char[][] spawnVehicle(Map map, LinkedList<Taxi> taxis) {


        taxis.findFirst();

        while (!taxis.isEmpty()) {
            Taxi currentTaxi = taxis.retrieve();
            map.map[currentTaxi.getX()][currentTaxi.getY()] = VehicleChar;

            taxis.findNext();
            if (taxis.isLast()) {
                break;
            }
        }
        return map.map;
    }

    public char[][] moveTaxis(LinkedList<Taxi> taxis, Map map, HashMap<String, Vehicle> listOfVehicles) {
        taxis.findFirst();

        while (!taxis.isEmpty()) {
            Taxi currentTaxi = taxis.retrieve();


            int currentX = currentTaxi.getX(); //get current taxi x and y
            int currentY = currentTaxi.getY();

            Random random = new Random();
            int randomMove = random.nextInt(4);
            map.map[currentTaxi.getX()][currentTaxi.getY()] = '.';
            switch (randomMove) {
                case 0: //up
                    currentTaxi.setY(currentY - 1); //moves upward 1 in the linkedList
                    listOfVehicles.get(currentTaxi.getReg()).setY(currentY - 1); //does the same for the HashMap
                    break;
                case 1: //Left
                    currentTaxi.setX(currentX - 1);
                    listOfVehicles.get(currentTaxi.getReg()).setX(currentX - 1);
                    break;
                case 2: //down
                    currentTaxi.setY(currentY + 1);
                    listOfVehicles.get(currentTaxi.getReg()).setY(currentY + 1);
                    break;
                case 3://right
                    currentTaxi.setX(currentX + 1);
                    listOfVehicles.get(currentTaxi.getReg()).setX(currentX + 1);
                    break;
            }

            taxis.findNext();

            if (taxis.isLast()) {
                break;
            }
        }
        return map.map;
    }

    //     The checkBorder method checks after a vehicle moves to see if it is touching a border before it moves again this ensures the vehicles don't move beyond the map
    public void checkBorder(LinkedList<Taxi> taxis) {
        taxis.findFirst();

        while (!taxis.isEmpty()) {
            Taxi currentTaxi = taxis.retrieve();

            if (currentTaxi.getX() < 0) {
                currentTaxi.setX(0);
            } else if (currentTaxi.getX() >= MAP_SIZE) {
                currentTaxi.setX(MAP_SIZE - 1);
            }

            if (currentTaxi.getY() < 0) {
                currentTaxi.setY(0);
            } else if (currentTaxi.getY() >= MAP_SIZE) {
                currentTaxi.setY(MAP_SIZE - 1);
            }

            taxis.findNext();
            if (taxis.isLast()) {
                break;
            }
        }
    }

    //  placeOnMap is used to place icons at given coordinates on the map we use this to place the customer
    public void placeOnMap(int x, int y, char icon) {
        map[x][y] = icon;

    }
}
