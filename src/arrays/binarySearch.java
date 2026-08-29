package arrays;

import java.io.*;
import static util.printer.*;
public class binarySearch
{
    static boolean binSearch(int[] arr, int key)
    {
        int len = arr.length;
        int lb=0, ub=len-1, mid;
        boolean flag = false;

        while(lb <= ub)
        {
            mid=(lb + ub) / 2;

            if(arr[mid] < key)
                lb=mid+1;
            if(arr[mid] > key)
                ub=mid-1;

            if(arr[mid] == key) {
                flag = true;
                break;
            }
        }

        return flag;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i, len, key;
        
        print("Enter the no. of items u want in the Array = ");
        len = Integer.parseInt(br.readLine());
        int[] arr=new int[len];

        println("Enter the numbers: ");
        for(i=0;i<len;i++)
            arr[i]=Integer.parseInt(br.readLine());

        println("Input Array: ");
        printArr(arr);

        sorting_Algorithms.bubbleSort(arr);
        println("Sorted Array: ");
        printArr(arr);

        print("Enter your searching number = ");
        key=Integer.parseInt(br.readLine());

        boolean flag = binSearch(arr, key);
        if(!flag)
            println("your searching number is not found");
        else
            println("No. FOUND!!!");

    }
}
