import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CapacitorVoltage
{
    public static void main(String[] args) throws FileNotFoundException
    {
        try
        {
            File inputFile = new File("params.txt");
            Scanner in = new Scanner(inputFile);
            PrintWriter out = new PrintWriter("rc.txt");

            double B = in.nextDouble();   //volts
            double R = in.nextDouble();   //resistance (ohms)
            double C = in.nextDouble();   //capacitance (microFarads)
            double tInitial = in.nextDouble();
            double tFinal = in.nextDouble();

            double v;   //corresponding voltage v(t)

            for(double t = tInitial; t < tFinal; t+=10)
            {
                v = B*(1 - (Math.exp(-t/(R*C))));
                out.printf("%10f%20f\n", t, v);
            }

            in.close();
            out.close();
        }

        
        catch(FileNotFoundException exception)
        {
            System.out.println("File Not Found");
        }
    }

}
