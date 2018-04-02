
/**
 * Write a description of class Daily here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Daily extends Appointment
{
    private boolean dailyOccurs;

    public Daily(int year, int month, int day, String des)
    {
        super(year, month, day, des);
    }

    public boolean occursOn(int Year, int Month, int Day)
    {
        
        if(Year > super.getYear())  //if the year is in the future, month/day are irrelevant
        {
            dailyOccurs = true;
        }
        
        else if(Year == super.getYear())    //if the year is the same
        {
            if(Month > super.getMonth())    //and the month is in the future
            {
                dailyOccurs = true;
            }
            if(Month == super.getMonth())   //or within the same month
            {
                if(Day >= super.getDay())   //and day is in the future
                {
                    dailyOccurs = true;
                }
            }
        }
        else
        {
            dailyOccurs = false;
        }
         
        
        return dailyOccurs;
    }
}
