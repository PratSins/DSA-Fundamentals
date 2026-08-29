import static util.printer.*;
import java.util.Arrays; // For Inbuilt sorting function
import java.util.Collections;
public class sorting_Algorithms
{
    public static void bubbleSort(int[] arr)
    {
        int t;
        int len = arr.length;
        for(int i=0; i<len; i++)
        {
            boolean flag = false;
            for(int j=0; j < (len-1); j++)
            {
                if(arr[j] > arr[j+1]) // Ascending ORDER
                {
                    flag = true;
                    t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }

            if(!flag)
                break;
        }
    }


    public static void selectionSort(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++)
        {
            int minPos = i;
            for(int j = i+1; j<arr.length; j++)
            {
                if(arr[minPos] > arr[j])
                    minPos = j;
            }

            if(minPos != i){
                int t = arr[minPos];
                arr[minPos] = arr[i];
                arr[i] = t;
            }
        }
    }

    public static void InsertionSort(int[] arr)
    {
        int len = arr.length;

        for(int i = 1; i<len; i++)
        {
            int current = arr[i];
            int j = i-1;

            while( j>=0 && arr[j]>current ){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }

    static void countingSort(int[] arr)
    {
        // Usd mostly for positive no.s and when the range/largest no. is small enough.
        int largest = Integer.MIN_VALUE, len = arr.length;
        for(int i=0;i<len; i++){
            largest = Math.max(largest, arr[i]);
        }

        int[] count = new int[largest+1];
        for(int i=0; i<len; i++){
            count[arr[i]]++;
        }

        int j = 0;
        for(int i=0; i<count.length; i++)
        {
            while(count[i] > 0)
            {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr2 = {-2,-3,4,-1,-2,1,5,-3};
        printArr(arr2);
//        InsertionSort(arr2);
        // In-built sorting functions
        // Time complexity = o(n log n)  -- Arrays.sort()
//        Integer[] arr3 = new Integer[arr2.length];
//
//        for (int i = 0; i < arr2.length; i++) {
//            arr3[i] = arr2[i];
//        }
//        Arrays.sort(arr3, Collections.reverseOrder());
//
//        printArr(arr3);
//
//        int[] arr = {12,11,10,9,8,7,6,5,4,3,2,1};
//        Arrays.sort(arr, 2, 7);

//        printArr(arr);

        println();
        int[] arr4 = {5,4,1,3,2};
        printArr(arr4);
        countingSort(arr4);
        printArr(arr4);



    }
}
