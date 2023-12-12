public class Person {

    private String name;
    private char icon = 'P';

    private int XcoOrd;
    private int YcoOrd;

    public Person(String name) {
        this.name = name;
        this.icon = icon;
        this.XcoOrd = XcoOrd;
        this.YcoOrd = YcoOrd;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(char icon) {
        this.icon = icon;
    }

    public int getXcoOrd() {
        return XcoOrd;
    }

    public void setXcoOrd(int xcoOrd) {
        XcoOrd = xcoOrd;
    }

    public int getYcoOrd() {
        return YcoOrd;
    }

    public void setYcoOrd(int ycoOrd) {
        YcoOrd = ycoOrd;
    }

    public char getIcon(){
        return icon;
    }
}
