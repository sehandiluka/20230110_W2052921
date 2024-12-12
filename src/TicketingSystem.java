import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketingSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Logger.log("System started");
        System.out.println("Welcome to the Real-Time Event Ticketing System CLI!");

        int totalTickets = 0, ticketReleaseRate = 0, customerRetrievalRate = 0, maxCapacity = 0;

        System.out.println("Would you like to load configuration from file? (yes/no)");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            Configuration config = Configuration.loadConfig();
            assert config != null;
            Logger.log("Configuration loaded successfully from file.");
            System.out.println("Thank you for waiting");
            maxCapacity =config.getMaximumCapacity();
            totalTickets = config.getTotalTickets();
            ticketReleaseRate = config.getTicketReleaseRate();
            customerRetrievalRate = config.getRetrievalRate();
        } else {
            try {
                maxCapacity = inputValidation("Enter maximum ticket capacity: ");
                totalTickets = totalTicketValidation(maxCapacity);
                ticketReleaseRate = inputValidation("Enter ticket release rate (tickets per second): ");
                customerRetrievalRate = inputValidation("Enter customer retrieval rate (tickets per second): ");

                Configuration.saveConfig(maxCapacity, totalTickets, ticketReleaseRate, customerRetrievalRate);
                Logger.log("Configuration saved successfully.");
            } catch (Exception e) {
                Logger.log("Invalid input encountered: " + e.getMessage());
                System.out.println("Invalid input. Please enter valid integers.");
                return;
            }
        }

        TicketPool ticketPool = new TicketPool(maxCapacity);

        Vendor vendor = new Vendor(ticketPool, ticketReleaseRate, totalTickets);
        Thread vendorThread = new Thread(vendor);
        vendorThread.start();

        Customer customer = new Customer(ticketPool, customerRetrievalRate);
        Thread customerThread = new Thread(customer);
        customerThread.start();

        System.out.println("System is running. Type 'q' to stop.");
        while (true) {
            String command = scanner.next();
            if (command.equalsIgnoreCase("q")) {
                vendor.stop();
                customer.stop();
                try {
                    vendorThread.join();
                    customerThread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                break;
            }
        }

        Logger.log("System stopped.");
        System.out.println("System stopped.");
    }

    public static int inputValidation(String message) {
        int input = 0;
        boolean isValid = true;
        while (isValid) {
            try {
                System.out.print(message);
                input = scanner.nextInt();
                if (input > 0) {
                    isValid = false;
                } else {
                    System.out.println("Enter again positive non-zero integer");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid integer");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static int totalTicketValidation(int maximumCapacity) {
        int totalTickets;
        while (true) {
            totalTickets = inputValidation("Enter total number of tickets: ");
            if (totalTickets > maximumCapacity) {
                System.out.println("Total tickets can't exceed maximum capacity");
                scanner.nextLine();
                continue;
            } else {
                break;
            }
        }
        return totalTickets;
    }
}
