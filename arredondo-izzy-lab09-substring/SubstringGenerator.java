import java.util.ArrayList;

/**
 * This class generates substrings of a string.
 */
public class SubstringGenerator 
{
    public static ArrayList<String> getSubstrings(String word) 
    {
        //this is the value you will return
        ArrayList<String> result = new ArrayList<String>();

        //come up with a base case first
        if (word.length() == 0)
        {
            result.add(word);
            return result; 
        }

        // Below here is the recursive case
        else
        {
            // Form a simpler word by removing the first character
            String simpler = word.substring(1);

            // Generate all substrings of the simpler word
            // This is where you will make a recursive call
            // You can store the result from this temporary call in 
            // your results ArrayList
            result=getSubstrings(simpler);

            // Add all strings that start with word.charAt(0)
            // You will need a loop here
            for (int i = 1; i <= word.length(); i++) 
            {
                result.add(word.substring(0,i));    //loop over word.length
            }
        }
        // Return all substrings
        return result;
    }
}