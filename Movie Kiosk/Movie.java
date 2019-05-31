import java.util.*;

public class Movie
{
    private String title;
    private int year;
    private int price;
    private Genre genre;
    // instance variables - replace the example below with your own
   
    public Movie(String title, int year, Genre genre, int price)
    {
        this.title = title;
        this.year = year;
        this.price = price;
        this.genre = genre;// initialise instance variables
        
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getGenre() {
        return genre.getName();
    }
    
    public Genre getGenreName() {
        return genre;
    }
    
    public int getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return (year + "\t" + title + "\t" + genre + "\t" + "$" + price);
    }

   
}
