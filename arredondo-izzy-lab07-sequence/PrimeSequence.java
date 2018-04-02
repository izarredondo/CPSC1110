public class PrimeSequence implements Sequence
{
    // instance variables
    private int prime;  
    private int x=2;    //counter variable

    public int next()
    {
        
        while(x != prime)
        {
            outerloop:
            for(int i=2; i < x ; i++)   //from 2 up until counter
            {
                if(x % i == 0)  //test for non-primes
                {
                    x++;
                    break outerloop;
                }
            }
            prime = x;  //if test fails, prime is assigned value of x
        }
        
        x++;    //increment x for next test
        return prime;   
    }
}
