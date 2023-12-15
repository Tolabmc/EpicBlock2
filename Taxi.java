public class Taxi {

    private int x;
    private int y;

    Taxi(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    boolean contains(int x, int y) {
        return this.x == x && this.y == y;
    }

    void move(int direction) {
        switch (direction) {
            case 0:
                y--;
                break;
            case 1:
                x--;
                break;
            case 2:
                y++;
                break;
            case 3:
                x++;
                break;
        }
    }

}
