package arrays;

import java.util.*;
import static util.printer.*;
public class arrReverse 
{
    static void reverse(int[] arr)
    {
        int len = arr.length;
        int temp;
        for(int i=0;i <= len/2; i++)
        {
            temp = arr[i];
            arr[i] = arr[len-i-1];
            arr[len-i-1] = temp;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        print("Enter the no. of items u want in the Array = ");
        int len = sc.nextInt();
        int[] arr=new int[len];

        println("Enter the numbers: ");
        for(int i=0;i<len;i++)
            arr[i]=sc.nextInt();

        println("Input Array: ");
        printArr(arr);

        reverse(arr);
        println("Reversed Array: ");
        printArr(arr);
    }
}
