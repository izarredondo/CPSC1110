/**
A class to simulate a combination lock.
 */
public class ComboLock
{

    //********* you will need to create appropriate instance variables here
    private int currentNumber = 0; //current value lock dial is set to
    //more variables here ....

    private int combo1;
    private int combo2;
    private int combo3;

    private int state;

    /**
    Initializes the combination of the lock.

     */
    //**** COMPLETE THIS CONSTRUCTOR - input should be 3 number combination
    //**** You may need to set other instance variables other than the 
    //**** arguments here
    //You should verify that the secret numbers are in the range 0-39 (inclusive)
    //if the values given are not in that range, clamp them.
    //i.e. the call new ComboLock(0, -20, 45) would create a combination of
    // 0, 0, 39  (the -20 gets clamped to 0 because it was less than 0)
    // (the 45 gets clamped to 39 because it was > 39).
    public ComboLock(int secret1, int secret2, int secret3)
    {
        //assigns inputs to seperate variables
        combo1 = secret1;
        combo2 = secret2;
        combo3 = secret3;
        
        //clamps out of range values
        if(secret1 > 39)
        {
            combo1 = 39;
        }
        if(secret1 < 0)
        {
            combo1 = 0;
        }
        if(secret2 > 39)
        {
            combo2 = 39;
        }
        if(secret2 < 0)
        {
            combo2 = 0;
        }
        if(secret3 > 39)
        {
            combo3 = 39;
        }
        if(secret3 < 0)
        {
            combo3 = 0;
        }
    }

    /**
    Resets the state of the lock so that it can be opened again.
     */
    //********* COMPLETE THIS METHOD
    public void reset()
    {
        currentNumber = 0;
        state = 0;
    }

    /**
    Turns lock left given number of ticks.
    @param ticks number of ticks to turn left
     */
    //*********COMPLETE THIS METHOD
    //you can assume that ticks will be a valid value between 0-40 
    //note that 40 ticks in either direction should return us back to the 
    //number we started on
    public void turnLeft(int ticks)
    {
        //left ticks increase the current number
        currentNumber += ticks;
        
        //if ticks increase the current number past 39..
        if(currentNumber > 39)
        {
            currentNumber -= 40; //..subtract 40 
        }
        
        //if first right turn matched first secret number,
        //and left turn matches second secret number
        if(state == 1 && currentNumber == combo2)
        {
            state = 2;  //change to state 2
        }

    }

    /**
    Turns lock right given number of ticks
    @param ticks number of ticks to turn right
     */
    //*********COMPLETE THIS METHOD
    //you can assume that ticks will be a valid value between 0-40 
    //note that 40 ticks in either direction should return us back to the 
    //number we started on
    public void turnRight(int ticks)
    {
        //right ticks decrease the current number 
        currentNumber = (currentNumber - ticks + 40)%40;
        
        //if right turn matches first secret number
        if(state == 0 && currentNumber == combo1)
        {
            state = 1; //change to state 1
        }
        
        //in state 2 the secret 1 and 2 have been matched,
        //if second right turn matches secret 3
        if(state == 2 && currentNumber == combo3)
        {
            state = 3;  //change to state 3
        }
    }

    /**
    Returns true if the lock can be opened now
    @return true if lock is in open state
     */
    //**** COMPLETE THIS METHOD
    public boolean open()
    {
        if(state == 3)
        {
            return true;    //all secret numbers matched in state 3
        }
        else
        {
            return false; 
        }
    }

    /**
    Returns current value dial is pointing at
    @return value dial is pointing at currently
     */
    public int getCurrentNumber() 
    {
        return currentNumber;
    }

}