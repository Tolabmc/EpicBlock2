import java.util.Random;
public enum Direction {

    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
     RIGHT(0, 1),
    RANDOM();


    private final int x;
    private final int y;
    /*
    private final int randX;
    private final int randY;

     */


    Direction() {

        Random rand = new Random();
        //this.x = rand.nextInt(3) - 1; // Random integer between -1 and 1
        //this.y = rand.nextInt(3) - 1; // Random integer between -1 and 1
        switch (rand.nextInt(4)) {
            case 0:
                this.x = -1;
                this.y = 0;
                break;
            case 1:
                this.x = 1;
                this.y = 0;
                break;
            case 2:
                this.x = 0;
                this.y = -1;
                break;
            case 3:
                this.x = 0;
                this.y = 1;
                break;
            default:
                // Handle unexpected case
                throw new IllegalStateException("Unexpected value: " + rand.nextInt(4));

        }
    }






   Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
   /* public int getRandX(){
        return randX;
    }
    public int getRandY(){
        return randY;
    }

    */

}




