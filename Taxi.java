public class Taxi {

    private int x;
    private int y;

    private String reg;



    Taxi(int x, int y, String reg) {
        this.x = x;
        this.y = y;
        this.reg = reg;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
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



}
