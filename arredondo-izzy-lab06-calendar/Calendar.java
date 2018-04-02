import java.util.*;
//sub

public class Calendar
{
    // instance variables 
    private ArrayList<Appointment> apts;
    
    public Calendar()
    {
        //construct arraylist of appointments
        apts = new ArrayList<Appointment>();
    }

    public void add(Appointment apt)
    {
        apts.add(apt);
    }

    public void remove(int year, int month, int day)
    {
        //this method needs to iterate over your list of appointments
        //and remove elements who's occursOn() method return true 
        //when passed the parameters above.
        for(int i=0; i < apts.size(); i++)
        {
            if(apts.get(i).occursOn(year, month, day) == true)
            {
                apts.remove(i); //if appointment occurs on said date, it is removed
            }
        }
        
        //wasn't iterating throughout
        for(int i=0; i < apts.size(); i++)
        {
            if(apts.get(i).occursOn(year, month, day) == true)
            {
                apts.remove(i);
            }
        }
    }

    
    public String toString() {
        String ret = "";
        //this method needs to iterate over your list of appointments
        //and construct the return string
        //make sure to put each appointment on its own line
        //by using “\n”
        
        for(int i=0; i < apts.size(); i++)
        {
            ret = ret + apts.get(i) +"\n"; 
        }
        return ret;
    }

}
