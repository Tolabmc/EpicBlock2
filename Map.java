import java.util.LinkedList;
import java.util.Random;

public class Map {

    private Person person;
    public static final int MAP_SIZE = 10;
    public static final char EMPTY = '.';
    public static final char VehicleChar = 'V';
    public static final char PersonChar = 'P';
//Person person = new Person("Jim",'P',2,7);
//    private char[][] map;

    public char[][] map;


    public Map() {
            map = new char[MAP_SIZE][MAP_SIZE];
            //person = new Person("Jim",'P',2,7);
       // initializeMap();
        }
/*
    public void placePerson(){
        placeOnMap(this.person.getXcoOrd(), this.person.getYcoOrd(), this.person.getIcon());
    }

 */
/*
    public void initializeMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                this.map[i][j] = EMPTY;
            }
        }
    }

 */

    public void printMap(char[][] map, LinkedList<Taxi> taxis) {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                boolean CarSquare = false;
                for (Taxi taxi : taxis) {
                    if (taxi.contains(j, i)) {
                        System.out.print(VehicleChar + " ");
                        CarSquare = true;
                        break;
                    }
                }
                if (!CarSquare) {
                    this.map[i][j] = EMPTY;
                    System.out.print(this.map[i][j] + " ");

                }
            }
            System.out.println();
        }
        //System.out.print(placeOnMap(2,7,'P'));

        for (int i = 0; i <= 5; i++) {
            System.out.println();
        }
    }


    public static void moveTaxis(LinkedList<Taxi> taxis, Random random) {
        for (Taxi taxi : taxis) {
            int randomMove = random.nextInt(4);
            taxi.move(randomMove);
        }
    }

    public static void checkBorder(LinkedList<Taxi> taxis) {
        for (Taxi taxi : taxis) {
            if (taxi.getX() < 0) {
                taxi.setX(0);

            } else if (taxi.getX() >= MAP_SIZE) {
                taxi.setX(MAP_SIZE - 1);
            }
            if (taxi.getY() < 0) {
                taxi.setY(0);
            } else if (taxi.getY() >= MAP_SIZE) {
                taxi.setY(MAP_SIZE - 1);
            }
        }
    }
    public void placeOnMap(int x, int y, char icon) {
        map[x][y] = icon;
    }
}

