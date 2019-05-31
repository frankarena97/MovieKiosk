import java.util.*;

public class Kiosk
{
    private Catalogue catalogue;
    private List<Customer> customers = new ArrayList<Customer>();// instance variables - replace the example below with your own

    public static void main(String[] args) {

        new Kiosk().use();
    }

    public Kiosk()
    {
        catalogue = new Catalogue(this);// initialise instance variables
        customers.add(new Customer(101, "Jaime", 10));
        customers.add(new Customer(102, "Luke", 10));
        customers.add(new Customer(103, "William", 1));
    }

    public void use() {
        char choice;
        while ((choice = readMainMenu()) != 'X')

            switch (choice) {
                case '1': catalogueMenu(); break;
                case '2': showCustomerRecord(); break;
                case '3': showFavourites(); break;
                case '4':  topUpAccount(); break;
                case '5': useAdmin(); break;
                default: help(); break;
            }
    }

    public void help() {
        System.out.println("Please enter a number between 1 and 5, or press X to exit.");
    }

    public void useAdmin() {
        char choice;
        while ((choice = readAdminMenu()) != 'R')

            switch (choice) {
                case '1': showCustomers(); break;
                case '2': addCustomer(); break;
                case '3': removeCustomer(); break;
                case '4': catalogue.viewAllMovies();  break;
                case '5': catalogue.addMovie(); break;
                case '6': catalogue.removeMovie(); break;
                case 'R': break;
                default: break;
            }
    }

    private char readMainMenu() {
        System.out.println("Welcome to the Movie Kiosk! Please make a selection from the menu:");
        System.out.println("1. Explore the catalogue.");
        System.out.println("2. View your customer record.");
        System.out.println("3. Show you favourite movies.");
        System.out.println("4. Top up account.");
        System.out.println("5. Enter Admin mode.");
        System.out.println("X. Exit the system.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    private char readAdminMenu() {
        System.out.println("Welcome to the administration menu:");
        System.out.println("1. List all customers.");
        System.out.println("2. Add a customer.");
        System.out.println("3. Remove a customer.");
        System.out.println("4. List all movies.");
        System.out.println("5. Add a movie to the catalogue.");
        System.out.println("6. Remove a movie from the catalogue.");
        System.out.println("R. Return to the previous menu.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    private void catalogueMenu() {
        catalogue.catalogueMenu();

    }

    private int readID() {
        System.out.println();
        System.out.print("Enter a customer ID: ");
        return In.nextInt();
    }

    private void showFavourites() {

        System.out.println();
        int ID = readCustomerID();
        int count = 0;

        for (Customer customer : customers) {
            if (customer.getID() == ID) {
                System.out.println(customer.getName() + "'s favourite movies are:");
                customer.Favourite();
            }
            else
                ++count;
        }
        if (count == customers.size()) {
            System.out.println("That customer does not exist.");
            System.out.println();

        }
    }

    private void topUpAccount() {
        int ID = readID();
        System.out.print("Enter the top-up amount:");
        int amount = In.nextInt();
        System.out.println();
        int count = 0;

        for (Customer customer : customers) {
            if (customer.getID() == ID) {
                customer.topUp(amount);
            }
            else
                ++count;
        }
        if (count == customers.size()) {
            System.out.println("That customer does not exist.");
            System.out.println();

        }
    }

    private void showCustomerRecord() {
        System.out.println();
        int ID = readCustomerID();
        int count = 0;

        for (Customer customer : customers) {
            if (customer.getID() == ID) {
                customer.customerRecord();
            }
            else
                ++count;
        }
        if (count == customers.size()) {
            System.out.println("That customer does not exist.");
            System.out.println();

        }
    }

    private void test() {
        Customer customer = customer(readID());
        if (customer != null) {
            System.out.print(customer);
            System.out.println();
        }
        else
            System.out.println("That customer does not exist.");
        System.out.println();
    }

    private Customer customer(int userID) {
        for (Customer customer: customers)
            if (customer.getID() == userID)
                return customer;
        return null;
    }

    private void addCustomer() {
        System.out.println();
        System.out.println("Adding a new customer.");
        customers.add(new Customer(readNewID(), readName(), readInitialBalance()));
        System.out.println("Customer added.");
        System.out.println();
    }

    public void removeCustomer() {
        System.out.println();
        System.out.println("Removing a customer.");
        int ID = readCustomerID();
        int count = 0;

        for (Customer customer : customers) {

            if (customer.getID() == ID) {
                customers.remove(customer);
                System.out.println("Customer removed.");
                System.out.println();
                break;
            }

            else
                ++count;

            if (count == customers.size()) {
                System.out.println("That customer does not exist.");
                System.out.println();
            }
        }
    }

    

    public void rentMovie() {
        catalogue.rentMovie(customers);
    }

    public void returnMovie() {
        catalogue.returnMovie(customers);
    }
    
    
    private int readCustomerID() {
        System.out.print("Enter a customer ID: ");
        return In.nextInt();
    }

    private int readValidID() {
        System.out.print("Enter a valid customer ID: ");
        return In.nextInt();
    }

    private String readMovieTitle() {
        System.out.print(" Enter the title of the movie you wish to rent: ");
        return In.nextLine();
    }

    private int readNewID() {
        System.out.print("Enter a new ID: ");
        return In.nextInt();
    }

    private String readName() {
        System.out.print("Enter the customer's name: ");
        return In.nextLine();
    }

    private int readInitialBalance() {
        System.out.print("Enter the customer's initial balance: ");
        return In.nextInt();
    }

    private void showCustomers() {
        System.out.println();
        System.out.println("The Kiosk has the following customers: ");
        for (Customer customer : customers) {

            System.out.println(customer);
        }
        System.out.println();
    }
}