
import java.util.Random;

public class Map {

    public static boolean endApp = false;
    private Customer customer;
    public static final int MAP_SIZE = 10;
    public static final char EMPTY = '.';
    public static final char VehicleChar = 'V';
    public static final char customerChar = 'P';


    public char[][] map;


    public Map() {
        map = new char[MAP_SIZE][MAP_SIZE];
        this.map = map;

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


    public static char[][] spawnVehicle(char[][] mapArray, LinkedList<Taxi> taxis) {


        taxis.findFirst();

        while (!taxis.isEmpty()) {
            Taxi currentTaxi = taxis.retrieve();
            mapArray[currentTaxi.getX()][currentTaxi.getY()] = VehicleChar;

                    taxis.findNext();
            if (taxis.isLast()) {
                break;
            }
        }
        return mapArray;
    }

    public static char[][] moveTaxis(LinkedList<Taxi> taxis, char[][] map) {
        taxis.findFirst();

        while (!taxis.isEmpty()) {
            Taxi currentTaxi = taxis.retrieve();



           int currentX =  currentTaxi.getX(); //define variables x and y
            int currentY =  currentTaxi.getY();


            Random random = new Random();
            int randomMove = random.nextInt(4);
            map[currentTaxi.getX()][currentTaxi.getY()] = '.';
            currentTaxi.move(randomMove);

            switch (randomMove) {
                case 0: //up
                    currentTaxi.setY(y--);
                    break;
                case 1: //Left
                    cux--;
                    break;
                case 2: //down
                    y++;
                    break;
                case 3://right
                    x++;
                    break;
            }





            taxis.findNext();

            if (taxis.isLast()) {
                break;
            }
        }
        return map;
    }
//     The checkBorder method checks after a vehicle moves to see if it is touching a border before it moves again this ensures the vehicles don't move beyond the map
    public static void checkBorder(LinkedList<Taxi> taxis) {
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

    public boolean searchAdjacentVehicles(char[][] mapArray, int x, int y) {
        // Define the surrounding squares' coordinates
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

        for (int i = 0; i < dx.length; i++) {

            int newX = x + dx[i];
            int newY = y + dy[i];
//            System.out.println("newx: " +newX);
//            System.out.println("newY: "+ newY);

            // Check if the coordinates are within the map boundaries
            if (isValid(newX, newY, mapArray.length)) {
                // Check if the square contains a vehicle
                if (mapArray[newX][newY] == VehicleChar) {
                    return true; // Vehicle found adjacent to the customer
                }
            }
        }
        return false; // No vehicle found adjacent to the customer
    }

    private boolean isValid(int x, int y, int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }

}

