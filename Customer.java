import java.util.Scanner;

public class Customer extends Person{




    public Customer(String name, char icon, int XcoOrd, int YcoOrd) {
        super(name, icon, XcoOrd, YcoOrd);


    }
    static void startMessage() {

        // Map map = new Map();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Request a ride? (y/n)");
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("y")) {
            if (input.equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Invalid input, please enter 'y' to request ride or 'n' to exit.");
            }
        }
    }

    public String requestTaxiType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like a regular or XL taxi? (r/xl)");
        String input2 = scanner.nextLine();
        if (input2.equalsIgnoreCase("r")) {
            return "Regular";
        } else if (input2.equalsIgnoreCase("xl")) {
            return "XL";
        } else System.out.println("invalid input.");
        return  requestTaxiType();
    }
}

