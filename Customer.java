import java.util.Scanner;

public class Customer extends Person{




    public Customer(String name, char icon, int XcoOrd, int YcoOrd) {
        super(name, icon, XcoOrd, YcoOrd);
        private static void RequestARide(Customer ) {
                TaxiLogic taxi = new TaxiLogic();

        Map map = new Map();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Request a ride? (y/n)");
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("y")) {
            if (input.equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please enter 'y' to request a ride or 'n' to exit.");
                input = scanner.nextLine();
            }
        }

        }
    }


}
