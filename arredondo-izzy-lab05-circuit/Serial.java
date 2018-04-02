//subclass

import java.util.ArrayList;

public class Serial extends Circuit
{
    //creates new empty ArrayList that can be composed of Circuit classes
    private ArrayList<Circuit> s_Circuits = new ArrayList<Circuit>();

    public Serial()
    {
        //I think this may be redundant,
        //the code works with or without it
        ArrayList<Circuit> sCircuits = new ArrayList<Circuit>(); 
    }

    //method to add new circuits
    public void add(Circuit c)
    {
        //add to list
        s_Circuits.add(c);
    }

    //method for series resistance formula, returns resistance
    public double getResistance()
    {
        //for each circuit in the list
        for(Circuit c : s_Circuits)
        {
            //update resistance by summing all resistances in series
            resistance += c.getResistance();
        }

        return resistance;
    }

    //reset for new test
    public void reset()
    {
        s_Circuits.clear();  //empties list
    }
}
