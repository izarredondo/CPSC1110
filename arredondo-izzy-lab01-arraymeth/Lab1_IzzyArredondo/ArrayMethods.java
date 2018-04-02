import java.util.Arrays;
import java.util.Random;

public class ArrayMethods 
{
    private int[] values;

    public ArrayMethods(int[] initialValues) 
    {
        values = Arrays.copyOf(initialValues, initialValues.length);
    }
    //a function to reset the array to the values passed in as a parameter
    //you will want to use this method after each test you do in the main
    //method
    public void setArray(int[] newValues) 
    {
        values = Arrays.copyOf(newValues, newValues.length);
    }

    public void printArray() 
    {
        System.out.println(Arrays.toString(values));
    }

    //part a, fill in this method
    public void swapFirstAndLast() 
    {
        int temp = values[0];
        values[0] = values[values.length-1];
        values[values.length-1] = temp;

    }

    //part b, fill in this method
    public void shiftRight() 
    {
        int last = values[values.length-1];  

        //assign values to that of the next 
        for( int index = values.length-2; index >= 0 ; index-- )
        {
            values[index+1] = values [index];
        }

        // wrap last element into first slot
        values[0] = last;
    }
    //Fill in the rest of the methods below this line for part c-j

    //part c
    public void replaceEvens()
    {
        //cycles through to replace even numbers with zero
        for( int i=0; i < values.length-1; i++)
        {
            if( values[i]%2 == 0)
            {
                values[i] = 0;
            }
        }
    }

    //part d
    public void replaceSmaller()
    {
        int[] copy = Arrays.copyOf(values, values.length);

        for( int i=1; i < values.length-1; i++)
        {
            //if left neighbor is greatest, replace
            if( copy[i-1] > copy[i+1] && copy[i-1] > copy[i]) 
            {
                values[i] = copy[i-1];
            }
            //if right neighbor is greatest, replace
            else if( copy[i-1] < copy[i+1] && copy[i+1] > copy[i]) 
            { 
                values[i] = copy[i+1];
            }

        }
    }

    //part e
    public void replaceMiddle()
    {
        int currentSize = values.length;

        //for even sets
        if(values.length%2 == 0)
        {
            //reassign middle two values and shift
            for(int i=(currentSize/2)+1; i < currentSize; i++)
            {
                values[i-2] = values[i];
            }

            values = Arrays.copyOf(values, values.length-2);
        }
        //for odd sets
        else
        {
            //reassign middle value and shift
            for(int i=(currentSize/2); i < currentSize; i++)
            {
                values[i-1] = values[i];
            }

            values = Arrays.copyOf(values, values.length-1);
        }

    }

    //part f
    public void evenToFront()
    {
        int pos = 0; //position for evens
        int pos2 = values.length-1; //position for odds
        int[] temp = Arrays.copyOf(values, values.length);

        for(int i= 0; i < values.length; i++)
        {
            if(temp[i]%2 == 0)
            {
                values[pos] = temp[i]; //copying from temp to position
                pos++; //moves position
            }
        }
        for(int i = values.length-1; i > 0; i--)
        {
            if(temp[i]%2 != 0)
            {
                values[pos2] = temp[i];
                pos2--; //moves position 2
            }
        }

    }

    //part g
    public int getSecondLargest()
    {
        int largest=0;
        int secondLargest=0;

        for(int i = 0; i < values.length; i++)
        {
            if (largest < values[i]) 
            {
                secondLargest = largest;
                largest = values[i];    //assigns largest value to variable
            }
            if (secondLargest < values[i] && largest != values[i])
            {
                secondLargest = values[i];  //assigns second largest value to variable
            }
        }

        return secondLargest;   //returns value 
    }

    //part h
    public boolean isSorted()
    {
        for(int i=1; i < values.length; i++)
        {
            if(values[i-1] > values[i]) //asks if previous value is larger than value at i
            {
                return false;   //returns false for unsorted list
            }
        }
        return true;    //returns true for sorted list
    }

    //part i
    public boolean hasAdjacentDuplicates()
    {
        for(int i=1; i < values.length; i++)
        {
            if(values[i-1] == values[i]) //asks if neighbor value is equal value at i
            {
                return true;   //returns true if ADJACENT duplicates are found
            }
        }
        return false;
    }

    //part j
    public boolean hasDuplicates()
    {
        Arrays.sort(values);    //sorts array to find adjacent duplicates
        for(int i=1; i < values.length; i++)
        {
            if(values[i-1] == values[i]) //asks if neighbor value is equal value at i
            {
                return true;   //returns true if ADJACENT duplicates are found
            }
        }
        return false;
    }

    public static void main(String[] args) 
    {
        //In your main method you should test your array methods
        //First fill an array with random values
        Random myGen = new Random();
        final int TEST_SIZE = 10;

        //our initial random test data goes into the following array
        int[] testValues = new int[TEST_SIZE];
        for (int i=0; i<testValues.length; i++) 
        {
            //fills the array with random ints between 1 and 50 inclusive
            testValues[i] = 1+myGen.nextInt(50);
        }

        //Now print the array to show initial values
        System.out.println("Initial Array:");
        //note the usage of the "toString()" method here to print the array
        System.out.println(Arrays.toString(testValues));
        //blank line
        System.out.println();

        //from here you should fill in code that tests parts a-j 
        //for problem E7.2 from the textbook
        //part a is done for you below.  You should follow this format
        //to test each of your methods.
        //create a new ArrayMethods object.
        ArrayMethods myMethods = new ArrayMethods(testValues);

        //Test methods below this line.

        //Test of swapFirstAndLast()
        System.out.println("Before call to swapFirstAndLast()");
        System.out.println(Arrays.toString(myMethods.values));
        //swap first and last element
        myMethods.swapFirstAndLast();
        System.out.println("After call to swapFirstAndLast()");
        System.out.println(Arrays.toString(myMethods.values));
        System.out.println();
        //reset the Array to the initial test values
        myMethods.setArray(testValues);

        //Test of shiftRight()
        System.out.println("Before call to shiftRight()");
        System.out.println(Arrays.toString(myMethods.values));
        //shift Array to the right, last element to first
        myMethods.shiftRight();
        System.out.println("After call to shiftRight()");
        System.out.println(Arrays.toString(myMethods.values));
        System.out.println();
        //reset Array to inital values
        myMethods.setArray(testValues);

        //Test of replaceEvens()
        System.out.println("Before call to replaceEvens()");
        System.out.println(Arrays.toString(myMethods.values));
        //replace even values in Array with zero
        myMethods.replaceEvens();
        System.out.println("After call to replaceEvens()");
        System.out.println(Arrays.toString(myMethods.values));
        System.out.println();
        //reset Array to inital values
        myMethods.setArray(testValues);

        //Test of replaceSmaller()
        System.out.println("Before call to replaceSmaller()");
        System.out.println(Arrays.toString(myMethods.values));
        //replace even values in Array with zero
        myMethods.replaceSmaller();
        System.out.println("After call to replaceSmaller()");
        System.out.println(Arrays.toString(myMethods.values));
        System.out.println();
        //reset Array to inital values
        myMethods.setArray(testValues);

        //Test of removeMiddle() EVEN
        System.out.println("Before call to replaceMiddle() EVEN");
        System.out.println(Arrays.toString(myMethods.values));
        //rempve middle two values, shift array
        myMethods.replaceMiddle();
        System.out.println("After call to replaceMiddle() EVEN");
        System.out.println(Arrays.toString(myMethods.values));
        System.out.println();
        //reset Array to inital values
        myMethods.setArray(testValues);

        //Test of removeMiddle() ODD
        myMethods.values = Arrays.copyOf(myMethods.values, myMethods.values.length-1);
        System.out.println("Before call to replaceMiddle() ODD");
        System.out.println(Arrays.toString(myMethods.values));
        //remove middle value, shift array
        myMethods.replaceMiddle();
        System.out.println("After call to replaceMiddle() ODD");
        System.out.println(Arrays.toString(myMethods.values));
        System.out.println();
        //reset Array to inital values
        myMethods.setArray(testValues);

        //Test of evenToFront()
        System.out.println("Before call to evenToFront()");
        System.out.println(Arrays.toString(myMethods.values));
        //move even values to front of array
        myMethods.evenToFront();
        System.out.println("After call to evenToFront()");
        System.out.println(Arrays.toString(myMethods.values));
        System.out.println();
        //reset Array to inital values
        myMethods.setArray(testValues);

        //Test of getSecondLargest()
        System.out.println("Before call to getSecondLargest()");
        System.out.println(Arrays.toString(myMethods.values));
        //return second largest value
        myMethods.getSecondLargest();
        System.out.println("The second largest value is:");
        System.out.println(myMethods.getSecondLargest());
        System.out.println();
        //reset Array to inital values
        myMethods.setArray(testValues);

        //Test of isSorted()
        System.out.println("Before call to isSorted()");
        System.out.println(Arrays.toString(myMethods.values));
        //returns true if array is sorted in increasing order
        myMethods.isSorted();
        System.out.println("Your list is in order:");
        System.out.println(myMethods.isSorted());
        System.out.println();
        //Test sorted list
        Arrays.sort(myMethods.values);  //sorts list
        System.out.println("Before call to isSorted() TEST");
        System.out.println(Arrays.toString(myMethods.values));
        System.out.println("Your list is in order:");
        System.out.println(myMethods.isSorted());
        System.out.println();
        //reset Array to inital values
        myMethods.setArray(testValues);

        //Test of hasAdjacentDuplicates()
        System.out.println("Before call to hasAdjacentDuplicates()");
        System.out.println(Arrays.toString(myMethods.values));
        //returns true if two ADJACENT duplicates are found
        System.out.println("This set contains adjacent duplicates:");
        System.out.println(myMethods.hasAdjacentDuplicates());
        System.out.println();
        //reset Array to inital values
        myMethods.setArray(testValues);
        
        //Test of hasDuplicates()
        System.out.println("Before call to hasDuplicates()");
        System.out.println(Arrays.toString(myMethods.values));
        //returns true if two duplicates are found
        System.out.println("This set contains duplicates:");
        System.out.println(myMethods.hasDuplicates());
        System.out.println();
        //reset Array to inital values
        myMethods.setArray(testValues);
    }
}