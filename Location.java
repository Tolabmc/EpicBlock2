public class Location {

    private int x;
    private int y;

    private char icon;



    public Location(int x, int y){
        this.x = x;
        this.y = y;
        this.icon = '.';
    }

    public char getIcon() {
        return icon;
    }

    public char setIcon(char icon) {
        this.icon = icon;
        return icon;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
