import java.util.Scanner;

    public class TaxiLogic {
        private Direction direction;


        Location vehicleLocation = new Location(2, 4);


        public void moveVehicle(Direction direction, Map map) {

            int newX = (vehicleLocation.getX() + direction.getX());
            int newY = (vehicleLocation.getY() + direction.getY());

            if (isValidMove(newX, newY, map)) {
                map.placeOnMap(vehicleLocation.getX(), vehicleLocation.getY(), Map.EMPTY);

                vehicleLocation.setX(newX);
                vehicleLocation.setY(newY);

                map.placeOnMap(newX, newY, 'V');

            } else {

                //find a way to change direction of the car when it hits a boundary

            }
        }
        public boolean isValidMove(int x, int y, Map map) {
            return x >= 0 && x < map.MAP_SIZE && y >= 0 && y < map.MAP_SIZE;
        }

        public Location getVehicleLocation(){
            return vehicleLocation;
        }
        private Location vehicleLocation;
        public void requestARide(String typeOfVehicle){


    /*
Find vehicles within 2r radius of the current Person location
Put these in an ArrayList
Sort this ArrayList by rank
(this is getVehiclesInRange())
Assign Vehicle to Customer
Remove Vehicle from Map (map[vehicleX][vehicleY]=’.’)
Redraw Map

     */

        }

        public void completeRide(){
/*
Put Vehicle back on map (map[vehicleX][VehicleY]=’V’
Prompt Person for driver rating
Update driverRating
Redraw Map


 */
        }

        public void moveTaxi(){

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter direction (W/A/S/D): ");
            char input = scanner.next().charAt(0);

            switch (input) {
                case 'w':
                    direction = Direction.UP;
                    break;
                case 'a':
                    direction = Direction.LEFT;
                    break;
                case 's':
                    direction = Direction.DOWN;
                    break;
                case 'd':
                    direction = Direction.RIGHT;
                    break;
            }


    /*
Pick a random direction (UP/DOWN/LEFT/RIGHT)
Move one cell at a time (i.e. add +1 to X/Y or -1/+1 to X/Y at random, like Snake)
Ensure collisions are avoided with walls
If you hit a wall, turn around


     */
        }

        public void removeVehicle(String reg){

    /*
Search listOfVehicles by key
Remove it from HashMap
Redraw Map


     */
        }

        public void getVehiclesInRange(Location loc, int r){

    /*
Find distance between Person and each Vehicle
Loop though listOfVehicles,
Compare distance between current location and vehicle location
Push within 2r distance into array
Return vehicles within the range


     */
        }

    }
