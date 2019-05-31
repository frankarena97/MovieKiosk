import java.util.*;

public class Customer
{
    private int ID;
    private String name;
    private int balance;
    private List <Movie> currentlyRented = new ArrayList<Movie>();
    private List <Movie> rentingHistory = new ArrayList<Movie>();
    // instance variables - replace the example below with your own

    public Customer(int ID, String name, int balance)
    {
        this.ID = ID;
        this.name = name;
        this.balance = balance;// initialise instance variables

    }

    public void Favourite() {
        
        List <String> movieTitles = new ArrayList<String>();
        
        for (Movie movie : rentingHistory) {
            
         movieTitles.add(new String(movie.getTitle()));
            
        }
        
        Map <String, Integer> count = new LinkedHashMap <String, Integer>();

        for (String title : movieTitles) 
            count.put(title, 1 + (count.containsKey(title) ? count.get(title) : 0));

        List<String> sortedMovieTitles = new ArrayList<String>(count.keySet());
        Collections.sort(sortedMovieTitles, new Comparator<String>() {
                @Override
                public int compare(String x, String y) {
                    return count.get(y) - count.get(x);
                }
            });
        
        int counter = 1;

        for (String movie : sortedMovieTitles) {
            for (Movie name : rentingHistory) {
                if (name.getTitle().equals(movie) && counter < 4) {
                   
                   System.out.println(name);
                   ++counter;
                   break;
                }
                else;
                }
            
            }
            System.out.println();
            
        }
    

    public void customerRecord() {
        System.out.println("ID: " + this.ID);
        System.out.println("Name: " + this.name);
        System.out.println("Balance: $" + this.balance);
        System.out.println("Movies currently rented by " + this.name + ":");
        for (Movie movieRented : currentlyRented) {
            System.out.println(movieRented);
        }
        System.out.println(this.name + "'s renting history:");
        for (Movie rentHistory : rentingHistory) {
            System.out.println(rentHistory);
        }
        System.out.println();
    }

    public void topUp(int amount) {
        System.out.println("Transaction complete.");
        System.out.println(this.name + "'s balance was: $" + this.balance);
        balance += amount;
        System.out.println(this.name + "'s current balance is: $" + this.balance);
        System.out.println();
    }

    @Override
    public String toString() {
        return (ID + "\t" + name + "\t" + " $ " + balance);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void newBalance(Movie movie) {
        balance -= movie.getPrice();
    }

    public List getCurrentlyRented() {
        return currentlyRented;
    }

    public List getRentingHistory() {
        return rentingHistory;
    }

    public void showCustomerRent() {
        for (Movie movie : currentlyRented) {
            System.out.println(movie);
        }
    }

    public void customerReturn(List <Movie> movies, List <Movie> rentedMovies) {
        String title = readMovieTitle();
        int count = 0;

        if (currentlyRented.size() == 0 ) {
            System.out.println("You have not rented this movie to return it.");
        }
        for (Movie movie: currentlyRented) {
            if (movie.getTitle().equals(title)) {
                currentlyRented.remove(movie);
                rentedMovies.remove(movie);

                movies.add(movie);

                System.out.println(movie.getTitle() + " has been returned.");
                break;
            }

            else 
                ++count;

            if (count == currentlyRented.size()) 
                System.out.println("You have not rented this movie to return it.");
        }

    }
    

    public String readMovieTitle() {
        System.out.print("Enter the title of the movie you wish to return: ");
        return In.nextLine();
    }

}

