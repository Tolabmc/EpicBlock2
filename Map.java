
import java.util.Random;

public class Map {

    public static boolean endApp = false;
    private Customer customer;
    public static final int MAP_SIZE = 10;
    public static final char EMPTY = '.';
    public static final char VehicleChar = 'V';
    public static final char customerChar = 'P';

//Person person = new Person("Jim",'P',2,7);
//    private char[][] map;

    public char[][] map;


    public Map() {
        map = new char[MAP_SIZE][MAP_SIZE];
        this.map = map;
        //person = new Person("Jim",'P',2,7);
        // initializeMap();
    }
/*
    public void placePerson(){
        placeOnMap(this.person.getXcoOrd(), this.person.getYcoOrd(), this.person.getIcon());
    }

 */

    public void initializeMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

/*
    taxis.start();
  while (!taxis.empty()) {
        Taxi currentTaxi = taxis.get();
        taxis.next();

        */

    public void printMap() {

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
        public void printMap(char[][] map, LinkedList<Taxi> taxis) {

            for (int i = 0; i < MAP_SIZE; i++) {
                for (int j = 0; j < MAP_SIZE; j++) {
                    boolean carSquare = false;

                    taxis.findFirst();

                    while (!taxis.isEmpty()) {

                        // System.out.print("i: " + i + "j: " + j);

                        Taxi currentTaxi = taxis.retrieve();

                        if (currentTaxi.contains(i, j)) {
                            System.out.print(VehicleChar + " ");
                            carSquare = true;
                            break;
                        }

                        taxis.findNext();
                        if (taxis.isLast()) {
                            break;
                        }
                    }
                    if (!carSquare) {
                        map[i][j] = EMPTY;
                        System.out.print(map[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    */
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


            Random random = new Random();
            int randomMove = random.nextInt(4);
            map[currentTaxi.getX()][currentTaxi.getY()] = '.';
            currentTaxi.move(randomMove);


            taxis.findNext();

            if (taxis.isLast()) {
                break;
            }
        }
        return map;
    }

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


    public void placeOnMap(int x, int y, char icon) {
        map[x][y] = icon;

    }
}


/*
public void printMap(char[][] map, LinkedList<Taxi> taxis) {

    taxis.start();
    System.out.print(taxis.get());

    for (int i = 0; i < MAP_SIZE; i++) {
        for (int j = 0; j < MAP_SIZE; j++) {
            boolean carSquare = false;



            for (Taxi taxi: taxis) {
                if (taxi.contains(j, i)) {
                    System.out.print(VehicleChar + " ");
                    carSquare = true;
                    break;
                }
            }
/*
                while (!taxis.empty()) {
                    System.out.print("i: " + i + "j: " + j);

                    Taxi currentTaxi = taxis.get();

                    if (currentTaxi.contains(j, i)) {
                        System.out.print(VehicleChar + " ");
                        carSquare = true;
                        break;
                    }

                    taxis.next();
                }

            if (!carSquare) {
                this.map[i][j] = EMPTY;
                System.out.print(map[i][j] + " ");
            }
        }
        System.out.println();
    }
}
*/
