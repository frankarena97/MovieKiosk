import java.util.*;

public class Genre
{
    private String name;
    // instance variables - replace the example below with your own
   
    public Genre(String name)
    {
        this.name = name;// initialise instance variables
       
    }
    @Override
    public String toString() {
        return (name);
    }
    
    public String getName() {
        return name;
    }
}
