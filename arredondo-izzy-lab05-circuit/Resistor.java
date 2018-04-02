//subclass


public class Resistor extends Circuit
{
   public double resistance;
   
   //constructor
   public Resistor(double r)
   {
       resistance = r;
   }
   
   //updates and overrides Circuit resistance
   public double getResistance()
   {
       return resistance;
   }
 
}
