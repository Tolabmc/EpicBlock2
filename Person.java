public class Person {

    private String name;
    private char icon = 'C';

    private int X;
    private int Y;

    public Person(String name, char icon, int X, int Y) {
        this.name = name;
        this.icon = icon;
        this.X = X;
        this.Y = Y;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char setIcon(char icon) {
        this.icon = icon;
        return icon;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        Y = Y;
    }

    public char getIcon(){
        return icon;
    }
}
