import java.util.Arrays;

/**
 * This program demonstrates the merge sort algorithm by sorting an array that
 * is filled with random numbers.
 */
public class MergeSortDemo 
{
    public static void main(String[] args)
    {
        // make an array with a size of a power of 2
        int[] a = ArrayUtil.randomIntArray((int) Math.round(Math.pow(2, 4)),
                100);
        System.out.println("Unsorted: ");
        System.out.println(Arrays.toString(a));

        MergeSorter.sort(a);
        System.out.println("Sorted: ");
        System.out.println(Arrays.toString(a));
    }
}