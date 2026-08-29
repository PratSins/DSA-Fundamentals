package arrays;

import static util.printer.*;
public class SubArrays
{
    static void printSubArr(int[] arr)
    {
        int ta = 0;
        for(int i=0; i < arr.length; i++)
        {
            for(int j=i; j < arr.length; j++)
            {
                print("[ ");
                for(int x=i; x <= j; x++)
                    print(arr[x]+" ");
                print("]      ");
                ta++;
            }
            println();
        }
        println("\nTotal no. of sub-Arrays = "+ta);  // ta = n(n+1)/2
    }
    public static void main(String[] args)
    {
        int[] arr = {2,4,6,8,10};
        printSubArr(arr);

    }
}
