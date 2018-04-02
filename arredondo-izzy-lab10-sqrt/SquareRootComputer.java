import java.util.Scanner;

/**
 * Greek's method to approximate the square root of a given number.
 */
public class SquareRootComputer 
{
    public static void main(String[] args) 
    {
        // this is your tester
        // read a value from the user and print the results 
        // along with expected value
        
        System.out.print("Enter a number: ");
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        
        System.out.println("The square root of " + n + " is: " + squareRoot(n));
        System.out.println("Expected value: " + Math.sqrt(n));
    }

    public static double squareRoot(double x) 
    {
        // from this method come up with a guess
        // and then make the call to the recursive method
        // squareRootGuesser()
        
        double guess = x/2;     //guess
        
        return squareRootGuess(x, guess);   //recursive method
    }

    private static double squareRootGuess(double x, double g) 
    {
        // recursive method to compute the square root of x
        // you will need to have a base case and a recursive case
        // in this method
        
        double betterGuess = (g + x/g)/2;   
        
        if(Math.abs(x-(g*g)) < 0.0001)  //test if g^2 is appr. equal to x
        {
            return g;
        }
        else
        {
            //recursive call using betterGuess as g and getting a smaller and smaller number until the if
            //statement is true
            return squareRootGuess(x, betterGuess);    
        }
          
    }
    
}