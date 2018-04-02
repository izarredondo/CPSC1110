import java.util.ArrayList;

/**
 * A class to run tests on the Circuit class and subclasses
 * @author Horstman
 * @version 02/06/2014
 *  
 */

public class CircuitDemo
{	/**
    method that implements tests for Circuit class and subclasses
    @param args - Not Used.
     */

    public static void main(String[] args)
    {
        //original test
        Parallel circuit1 = new Parallel();
        circuit1.add(new Resistor(100));
        Serial circuit2 = new Serial();
        circuit2.add(new Resistor(100));
        circuit2.add(new Resistor(200));
        circuit1.add(circuit2);
        System.out.println("Combined resistance: " + circuit1.getResistance());
        System.out.println("Expected: 75.0");
        System.out.println();

        //reset resistance and serial/parallel ArrayLists for new test
        //seems a bit redundant, there's more than likely a more efficient way
        Circuit reset = new Circuit();
        reset.reset();
        Serial reset1 = new Serial();
        reset1.reset();
        Parallel reset2 = new Parallel();
        reset2.reset();

        //new test
        Parallel circuit3 = new Parallel();
        circuit3.add(new Resistor(200));
        Serial circuit4 = new Serial();
        circuit4.add(new Resistor(100));
        circuit4.add(new Resistor(200));
        circuit3.add(new Resistor(100));
        circuit4.add(new Resistor(200));
        circuit4.add(new Resistor(100));
        circuit3.add(circuit4);
        Parallel circuit5 = new Parallel();
        circuit5.add(new Resistor(100));
        circuit5.add(circuit3);
        System.out.println("Combined resistance: " + circuit5.getResistance());
        System.out.println("Expected: 37.5");
        System.out.println();

    }
}