import java.util.*;

public class Catalogue
{
    private Kiosk kiosk;
    private List <Movie> moviesAvailable = new ArrayList<Movie>();
    private List <Movie> moviesRented = new ArrayList<Movie>();
    private List <Genre> genres = new ArrayList<Genre>();
    // instance variables - replace the example below with your own

    public Catalogue(Kiosk kiosk)
    {
        this.kiosk = kiosk;

        moviesAvailable.add(new Movie("Matrix", 1999, new Genre("SciFi"), 3));
        moviesAvailable.add(new Movie("Jurassic Park", 1993, new Genre("SciFi"), 4));
        moviesAvailable.add(new Movie("Terminator 2", 1991, new Genre("SciFi"), 3));
        moviesAvailable.add(new Movie("Titanic", 1997, new Genre("Drama"), 4));// initialise instance variables
        moviesAvailable.add(new Movie("The Silence of the Lambs", 1991, new Genre("Crime"), 3));

        genres.add(new Genre("SciFi"));
        genres.add(new Genre("Drama"));
        genres.add(new Genre("Crime"));
    }

    public void catalogueMenu() {
        char choice;
        while ((choice = readCatalogueMenu()) != 'R')

            switch (choice) {
                case '1': viewAllMovies(); break;
                case '2': viewAllAvailableMovies(); break;
                case '3': viewGenres(); break;
                case '4': showMovieGenres(); break;
                case '5': showMovieYears(); break;
                case '6': kiosk.rentMovie(); break;
                case '7': kiosk.returnMovie(); break;
                case 'R': kiosk.use(); break;
                default: catalogueHelp(); break;
            }
    }

    public char readCatalogueMenu() {
        System.out.println("Welcome to the Catalogue! Please make a selection from the menu:");
        System.out.println("1. Display all movies.");
        System.out.println("2. Display all available movies.");
        System.out.println("3. Display all genres.");
        System.out.println("4. Display movies in a genre.");
        System.out.println("5. Display all movies by year.");
        System.out.println("6. Rent a movie.");
        System.out.println("7. Return a movie.");
        System.out.println("R. Return to previous menu.");
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    public void catalogueHelp() {
        System.out.println("Please enter a number between 1 and 7 or press R to return to the previous menu.");
    }

    public void viewGenres() {
        System.out.println();
        System.out.println("The Kiosk has movies in the following genres:");
        for (Genre genre : genres) {
            System.out.println(genre);
        }
        System.out.println();
    }

    public void showMovieGenres() {
        List <Movie> allMovies = new ArrayList <Movie>();
        List <Movie> movieGenre = new ArrayList <Movie>();
        allMovies.addAll(moviesAvailable);
        allMovies.addAll(moviesRented);

        System.out.println();
        String genre = getGenre();
        System.out.println("The kiosk has the following movies in that genre:");
        for (Movie movie : allMovies) {
            if (movie.getGenre().equals(genre)) {

                movieGenre.add(movie);

            }
            else
                ;
        }
        for (Movie movie : movieGenre) {
            System.out.println(movie);
        }
        System.out.println();
    }

    public void showMovieYears() {
        List <Movie> allMovies = new ArrayList <Movie>();
        List <Movie> movieYears = new ArrayList <Movie>();
        allMovies.addAll(moviesAvailable);
        allMovies.addAll(moviesRented);

        System.out.println();
        int year = getYear();
        System.out.println("The kiosk has the following movies by that year:");
        for (Movie movie : allMovies) {
            if (movie.getYear() == year) {

                movieYears.add(movie);

            }
            else
                ;
        }
        for (Movie movie : movieYears) {
            System.out.println(movie);

        }
        System.out.println();
    }

    public void trial() {

        System.out.println();
        System.out.println("The Kiosk has the following movies:");

        for (Movie movie : moviesRented) {
            System.out.println(movie);
        }
        System.out.println();

    }

    public void viewAllMovies() {

        System.out.println();
        System.out.println("The Kiosk has the following movies:");

        for (Movie movie: moviesAvailable) {
            System.out.println(movie);
        }
        for (Movie movie: moviesRented) {
            System.out.println(movie);
        }
        System.out.println();
    }

    public void viewAllAvailableMovies() {
        System.out.println();
        System.out.println("The following movies are available:");
        for (Movie movie: moviesAvailable) {
            System.out.println(movie);
        }
        System.out.println();
    }

    public void viewRentedMovies() {
        for (Movie movie: moviesRented) {
            System.out.println(movie);
        }
    }

    public void addMovie() {
        System.out.println();
        System.out.println("Adding a new movie.");

        String movieTitle = readMovieTitle();
        int movieYear = readMovieYear();
        Genre genre = new Genre(readMovieGenre());
        int moviePrice = readMoviePrice();
        int count = 0;
        for (Movie movie : moviesAvailable) {
            if (movie.getTitle().equals(movieTitle)) {
                System.out.println("The movie is already in the catalogue.");

            }
            else
                count++;
        }
        if (count == moviesAvailable.size()) {
            moviesAvailable.add(new Movie(movieTitle, movieYear, genre, moviePrice));
            System.out.println("Added "  + movieTitle + " to catalogue.");
            System.out.println();

        }
        int counter = 0;
        for (Genre names : genres) {
            if (!(names.getName().equals(genre.getName()))) {
                ++counter;
            }
        }
        if (counter == genres.size()) {
            genres.add(new Genre(genre.getName()));
        }

    }

    public void removeMovie() {
        System.out.println();
        System.out.println("Removing a movie.");
        String title = readMovieTitle();
        int year = readMovieYear();
        int count = 0;
        for (Movie movie : moviesAvailable) {
            if (movie.getTitle().equals(title) && movie.getYear() == year) {
                moviesAvailable.remove(movie);
                System.out.println(movie + " removed from catalogue.");
                System.out.println();
                break;
            }
            else
                count++;

            if (count == moviesAvailable.size()) {
                System.out.println("No such movie found.");
                System.out.println();
            }

        }
    }

    public void rentMovie(List <Customer> customers) {
        System.out.println();
        int ID = readValidID();
        String title = readTitle();
        int count = 0;
        int count2 = 0;
        int counter = 0;
        for (Customer customer : customers) {
            if (customer.getID() != ID) {
                ++count;
            }
            else
                for (Movie movie : moviesAvailable) {

                    if (!(movie.getTitle().equals(title))) {
                        ++count2;

                    }

                    if (customer.getBalance() < movie.getPrice() ) {
                        ++counter;
                    }
                    if (movie.getTitle().equals(title) && customer.getBalance() >= movie.getPrice()) {

                        customer.newBalance(movie);
                        customer.getCurrentlyRented().add(movie);
                        customer.getRentingHistory().add(movie);
                        moviesAvailable.remove(movie);
                        moviesRented.add(movie);
                        System.out.println("Movie rented.");
                        System.out.println();
                        break;
                    }

                    if (counter == moviesAvailable.size()) {
                        System.out.println("You don't have sufficient funds to rent this movie.");
                        System.out.println();
                        break;
                    }

                    if (count2 == moviesAvailable.size()) {
                        System.out.println("That movie is not available or doesn't exist.");
                        System.out.println();
                        break;
                    }
                }
            if (count == customers.size()) {
                System.out.println("Customer does not exist.");
                System.out.println();
            }

        }
    }

    public void returnMovie(List <Customer> customers) {
        System.out.println();
        int ID = readValidID();
        int count = 0;
        for (Customer customer : customers) {
            if (customer.getID() != ID)
            {
                ++count;
            }
            else {
                System.out.println(customer.getName() + " has the following movies: ");
                System.out.println("Movies currently rented by " + customer.getName() + ":");
                customer.showCustomerRent();
                customer.customerReturn(moviesAvailable, moviesRented);
                System.out.println();
            }

        }
        if (count == customers.size()) {
            System.out.println("Customer does not exist.");
        }

    }
    
    
    
        
        
        
    
    private String getGenre() {
        System.out.print("Enter a genre: ");
        return In.nextLine();
    }

    private int getYear() {
        System.out.print("Enter the year: ");
        return In.nextInt();
    }

    private int readValidID() {
        System.out.print("Enter a valid customer ID: ");
        return In.nextInt();
    }

    private String readTitle() {
        System.out.print("Enter the title of the movie you wish to rent: ");
        return In.nextLine();
    }

    private String readMovieTitle() {
        System.out.print("Enter the title of the movie: " );
        return In.nextLine();
    }

    private int readMovieYear() {
        System.out.print("Enter the year: ");
        return In.nextInt();
    }

    private String readMovieGenre() {
        System.out.print("Enter the genre: ");
        return In.nextLine();
    }

    private int readMoviePrice() {
        System.out.print("Enter price: ");
        return In.nextInt();
    }

    public List getMoviesAvailable() {
        return moviesAvailable;
    }

    public List getMoviesRented() {
        return moviesRented;
    }
}
