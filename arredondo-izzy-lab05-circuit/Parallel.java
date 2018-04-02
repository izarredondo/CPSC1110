//subclass

import java.util.ArrayList;

public class Parallel extends Circuit
{
    //creates new empty ArrayList that can be composed of Circuit classes
    private ArrayList<Circuit> p_Circuits = new ArrayList<Circuit>();

    public Parallel()
    {
        //I think this may be redundant,
        //the code works with or without it
        //ArrayList<Circuit> pCircuits = new ArrayList<Circuit>();
    }
    
    //method to add new circuits
    public void add(Circuit c)
    {
        //add to list
        p_Circuits.add(c);
    }

    //method for parallel resistance formula, returns resistance
    public double getResistance()
    {
        //for each circuit in list
        for(Circuit c : p_Circuits)
        {
            //update resistance by summing inverse of each resistance in parallel
            resistance += (1.0/c.getResistance()); 
        }

        //parallel resistance equals inverse of sum
        return 1.0/resistance;
    }

    //reset for new test 
    public void reset()
    {
        p_Circuits.clear();  //empties list
    }
}
