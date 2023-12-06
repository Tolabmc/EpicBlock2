public class Map {

    private static final int MAP_SIZE = 10;
    private static final char EMPTY = '.';
    public static final char Vehicle = 'V';
    public static final char Person = 'P';

    private char[][] map;

    public Map() {
        map = new char[MAP_SIZE][MAP_SIZE];
        initializeMap();
    }

    public void initializeMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();
        }
    }
    public void placeOnMap(int x, int y, char type){
        map[x][y] = type;

    }

}
