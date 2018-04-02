//sub

public class Monthly extends Appointment
{
    // instance variables 
    private boolean monthlyOccurs;

    /**
     * Constructor for objects of class Monthly
     */
    public Monthly(int Year, int Month, int Day, String Des)
    {
        super(Year, Month, Day, Des);
    }
    
    //overrides Appointment method
    public boolean occursOn(int Year, int Month, int Day)
    {
        
        if(Year > super.getYear() && Day == super.getDay()) //if the year is in the future and day is the same
        {
            monthlyOccurs = true;  
        }
        
        else if(Year == super.getYear())    //if within the same year
        {
            if(Month >= super.getMonth())   //the month must be the same or in the future
            {
                if(Day == super.getDay())   //and day is the same
                {
                    monthlyOccurs = true;
                }
            }
        }
        else
        {
            monthlyOccurs = false;
        }
         
        
        return monthlyOccurs;
    }
}
