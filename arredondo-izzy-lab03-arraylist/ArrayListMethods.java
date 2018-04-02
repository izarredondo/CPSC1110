import java.util.Collections; //need this one for sorting ArrayList
import java.util.Random;
import java.util.ArrayList;

public class ArrayListMethods {

    //ArrayList to hold values to work on for lab
    private ArrayList<Integer> listValues;

    //ArrayList constructor
    public ArrayListMethods(ArrayList<Integer> initialValues) {
        //note this shows how to make a copy of an array list
        //simply pass the old list in as an argument to 
        //the ArrayList constructor
        listValues = new ArrayList<Integer>(initialValues);
    }

    //set listValues to list passed as parm
    //use this method to "reset" our ArrayList data before each test
    public void setArrayList(ArrayList<Integer> newValues) {
        listValues = new ArrayList<Integer>(newValues);
    }

    //method to print the current values in the ArrayList
    //or you can simply use println() with the array list as the
    //parameter
    public void printArrayList() 
    {
        System.out.println(listValues);
    }

    //part a, done for you.
    public void swapFirstAndLast() 
    {
        //save first element
        int temp = listValues.get(0);
        //move last element to first position (0)
        listValues.set(0,  listValues.get(listValues.size()-1));
        //put temp value into last position (size() -1)
        listValues.set(listValues.size()-1, temp);
    }

    //part b, fill in this method
    public void shiftRight() 
    {
        //add last element to first position
        listValues.add(0, listValues.get(listValues.size()-1));
        //remove last element
        listValues.remove(listValues.size()-1);
    }

    //part c, set all even elements to 0.
    public void setEvensToZero() 
    {
        //iterate through ArrayList
        for(int i = 0; i < listValues.size(); i++)
        {
            //if value at i is even
            if(listValues.get(i)%2 == 0) 
            {
                //set value to zero
                listValues.set(i,0);
            }
        }
    }

    //part d, replace each element except the first and last by larger of two 
    //around it
    public void largerOfAdjacents() 
    {
        ArrayList<Integer> newList = new ArrayList<Integer>(listValues);

        for( int i=1; i < listValues.size()-1; i++)
        {
            //if left neighbor is greatest, replace
            if(newList.get(i-1) > newList.get(i+1)) 
            {
                listValues.set(i, newList.get(i-1));
            }
            //if right neighbor is greatest, replace
            else if(newList.get(i-1) < newList.get(i+1)) 
            { 
                listValues.set(i, newList.get(i+1));
            }

        }

    }

    //part e, remove middle el if odd length, else remove middle two els.
    public void removeMiddle() 
    {
        int currentSize = listValues.size();
        //for even sets
        if(listValues.size()%2 == 0)
        {
            //remove middle and shift
            listValues.remove(currentSize/2);
            listValues.remove((currentSize/2)-1);
        }
        //for odd sets
        else
        {
            //remove middle and shift
            listValues.remove(currentSize/2);
        }
    }

    //part f - move all evens to front
    public void moveEvensToFront() 
    {
        int pos = 0; //position for evens
        int pos2 = listValues.size()-1; //position for odds
        ArrayList<Integer> temp = new ArrayList<Integer>(listValues);

        for(int i= 0; i < listValues.size(); i++)
        {
            if(temp.get(i)%2 == 0)
            {
                listValues.set(pos, temp.get(i)); //copying from temp to position
                pos++; //moves position
            }
        }
        for(int i = listValues.size()-1; i > 0; i--)
        {
            if(temp.get(i)%2 != 0)
            {
                listValues.set(pos2, temp.get(i));
                pos2--; //moves position 2
            }
        }
    }

    //part g - return second largest el in array
    public int ret2ndLargest() 
    {
        int largest=0;
        int secondLargest=0;

        for(int i = 0; i < listValues.size(); i++)
        {
            if (largest < listValues.get(i)) 
            {
                secondLargest = largest;
                largest = listValues.get(i);    //assigns largest value to variable
            }
            if (secondLargest < listValues.get(i) && largest != listValues.get(i))
            {
                secondLargest = listValues.get(i);  //assigns second largest value to variable
            }
        }

        return secondLargest;   //returns value 
    }

    //part H - returns true if array is sorted in increasing order 
    public boolean isSorted() {
        boolean isSorted = true; //initially assume list is sorted
        for(int i=1; i < listValues.size(); i++)
        {
            //asks if previous value is larger than value at i
            if(listValues.get(i-1) > listValues.get(i)) 
            {
                isSorted = false;   //returns false for unsorted list
            }
        }
        
        return isSorted; //dummy value
    }

    //PART I - return true if array contains 2 adjacent duplicate values
    public boolean hasAdjDuplicates() {
        boolean hasDup = false; //assume no duplicates, then search array
        
        for(int i=1; i < listValues.size(); i++)
        {
            if(listValues.get(i-1) == listValues.get(i)) //asks if neighbor value is equal value at i
            {
                hasDup = true;   //returns true if ADJACENT duplicates are found
            }
        }
        return hasDup;
    }

    //PART J - return true if array contains 2 duplicate values
    //duplicates need not be adjacent to return true
    public boolean hasDuplicates() {
        boolean hasDup = false; //assume no duplicates, then search array
        Collections.sort(listValues);
        for(int i=1; i < listValues.size(); i++)
        {
            if(listValues.get(i-1) == listValues.get(i)) //asks if neighbor value is equal value at i
            {
                hasDup = true;   //returns true if ADJACENT duplicates are found
            }
        }
        return hasDup;
    }

    public static void main(String[] args) {
        //In your main method you should test your array methods
        //First fill an array with random values
        Random myGen = new Random();
        final int TEST_SIZE = 10;
        //our initial random test data goes into the following array list
        //don't make changes to this array, it will hold your test data
        ArrayList<Integer> listTestValues = new ArrayList<Integer>();
        //fill in test arrayList
        for (int i=0; i<TEST_SIZE; i++) {
            //fills the array List with random ints between 1 and 50 inclusive
            listTestValues.add(1+myGen.nextInt(50));
        }

        //Now print the array list to show initial values
        System.out.println("Initial Array List:");
        //you can use the following line to print the list
        System.out.println(listTestValues);
        System.out.println();

        //from here you should fill in code that tests parts a-j 
        //for problem E7.2 from the textbook
        //part a is done for you below.  You should follow this format
        //to test each of your methods.
        //create a new ArrayListMethods object.
        //note the following line will also initialize our arraylist data
        ArrayListMethods myMethods = new ArrayListMethods(listTestValues);

        //Test methods below this line.

        //Test of swapFirstAndLast()
        System.out.println("Before call to swapFirstAndLast():");
        System.out.println(myMethods.listValues);
        //swap first and last element
        myMethods.swapFirstAndLast();
        System.out.println("After call to swapFirstAndLast():");
        System.out.println(myMethods.listValues);
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);

        //***Begin second test below this line

        //Test of shiftRight()
        System.out.println("Before call to shiftRight():");
        System.out.println(myMethods.listValues);
        //shift array list to right
        myMethods.shiftRight();
        System.out.println("After call to shiftRight():");
        System.out.println(myMethods.listValues);
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);

        //Test of setEvensToZero()
        System.out.println("Before call to setEvensToZero():");
        System.out.println(myMethods.listValues);
        //replace even els with zero
        myMethods.setEvensToZero();
        System.out.println("After call to setEvensToZero():");
        System.out.println(myMethods.listValues);
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);

        //Test of largerOfAdjacents()
        System.out.println("Before call to largerOfAdjacents():");
        System.out.println(myMethods.listValues);
        //replace el with larger of neighbors
        myMethods.largerOfAdjacents();
        System.out.println("After call to largerOfAdjacents():");
        System.out.println(myMethods.listValues);
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);

        //Test of removeMiddle() EVEN
        System.out.println("Before call to removeMiddle(): EVEN");
        System.out.println(myMethods.listValues);
        //remove two middle els
        myMethods.removeMiddle();
        System.out.println("After call to removeMiddle():");
        System.out.println(myMethods.listValues);
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);
        
        //Test of removeMiddle() ODD
        myMethods.listValues.remove(myMethods.listValues.size()-1); 
        System.out.println("Before call to removeMiddle(): ODD");
        System.out.println(myMethods.listValues);
        //remove middle el
        myMethods.removeMiddle();
        System.out.println("After call to removeMiddle():");
        System.out.println(myMethods.listValues);
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);
        
        //Test of moveEvensToFront()
        System.out.println("Before call to moveEvensToFront():");
        System.out.println(myMethods.listValues);
        //move even els to front
        myMethods.moveEvensToFront();
        System.out.println("After call to moveEvensToFront():");
        System.out.println(myMethods.listValues);
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);
        
        //Test of ret2ndLargest()
        System.out.println("Before call to ret2ndLargest():");
        System.out.println(myMethods.listValues);
        System.out.println("After call to ret2ndLargest():");
        //prints second largest el
        System.out.println(myMethods.ret2ndLargest());
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);
        
        //Test of isSorted()
        System.out.println("Before call to isSorted():");
        System.out.println(myMethods.listValues);
        System.out.println("After call to isSorted():");
        //tells whether list is sorted or not
        System.out.println(myMethods.isSorted());
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);
        //Test sorted list
        Collections.sort(myMethods.listValues); //sorts list
        System.out.println("Before call to isSorted(): TEST");
        System.out.println(myMethods.listValues);
        System.out.println("After call to isSorted():");
        //tells whether list is sorted or not
        System.out.println(myMethods.isSorted());
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);
        
        //Test of hasAdjDuplicates()
        System.out.println("Before call to hasAdjDuplicates():");
        System.out.println(myMethods.listValues);
        System.out.println("After call to hasAdjDuplicates():");
        //tells if list has adjacent duplicates
        System.out.println(myMethods.hasAdjDuplicates());
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);
        
        //Test of hasDuplicates()
        System.out.println("Before call to hasDuplicates():");
        System.out.println(myMethods.listValues);
        System.out.println("After call to hasDuplicates():");
        //tells if list has any duplicates
        System.out.println(myMethods.hasDuplicates());
        System.out.println();
        //reset the Array List to the initial test values
        myMethods.setArrayList(listTestValues);
    }
}