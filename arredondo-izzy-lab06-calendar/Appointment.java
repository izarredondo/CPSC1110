
/**
 * SUPER
 */
public class Appointment
{
    // instance variables
    
    private int year;
    private int month;
    private int day;
    private String des;
    
    

    /**
     * Constructor for objects of class Appointment
     */
    public Appointment(int Year, int Month, int Day, String Des)
    {
        year = Year;
        month = Month;
        day = Day;
        des = Des;
    }

    public boolean occursOn(int Year, int Month, int Day)
    {
        //applies to subclasses, ovewritten by Daily and Monthly
        if(Year == year && Month == month && Day == day)    //onetime constraints
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    public int getYear()
    {
        return year;    
    }
    
    public int getMonth()
    {
        return month;
    }
    
    public int getDay()
    {
        return day;
    }
    
    public String getDescription()
    {
        return des;
    }
    
    public String toString() {
        String ret = "";
        
        ret = getClass().getName() + "[" + getDescription() + " Date: " + getMonth() + "/" + getDay() + "/" + getYear() + "]" +"\n";
        
        return ret;
    }
   
}
