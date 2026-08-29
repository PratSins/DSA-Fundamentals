package arrays;

import static util.printer.*;
public class arrPairs
{
    public static void printPairs(int[] arr)    // Time Complexity = O(n^2)
    {
        int tp=0;
        for(int i=0; i < arr. length; i++)
        {
            int curr = arr[i];
            for(int j=i+1; j < arr.length; j++)
            {
                print("(" + curr +","+arr[j]+")  ");
                tp++;
            }
            println("");
        }
        println("Total no. of pairs = "+tp); // tp = nC2 -- combinations
    }

    public static void main(String[] args)
    {
        int[] arr = {2,4,6,8,10};
        printPairs(arr);

    }
}
