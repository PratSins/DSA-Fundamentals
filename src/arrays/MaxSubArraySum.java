package arrays;

import static util.printer.*;
public class MaxSubArraySum
{
    static void maxSubArr1(int[] arr) // Brute Force method
    {
        // Time Complexity = O(n^3)
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        for(int i=0; i < arr.length; i++)
        {
            for(int j=i; j < arr.length; j++)
            {
                currSum = 0;
                for(int x=i; x <= j; x++) {
                    currSum += arr[x];
                }
                print(currSum+"   ");
                if(maxSum < currSum)
                    maxSum = currSum;
            }
            println();
        }

        println(" > The maximum sub array sum = "+maxSum);
    }

    static void maxSubArr2(int[] arr) // Prefix Sum method
    {
        // Time Complexity = O(n^2)
        int len = arr.length, currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int[] prefix = new int[len];

        prefix[0] = arr[0];
        for(int i=1; i<len; i++)
            prefix[i] = prefix[i-1] + arr[i];

        for(int i=0; i < len; i++)
        {
            int start = i;
            for(int j=i; j < len; j++)
            {
                int end = j;

                currSum = (start==0) ? prefix[end] : prefix[end] - prefix[start-1];

                print(currSum+"   ");
                if(maxSum < currSum)
                    maxSum = currSum;
            }
            println();
        }

        println(" >> The maximum sub array sum = "+maxSum);
    }

    static void maxSubArr3(int[] arr) // Kadane's Algorithm
    {
        // Time Complexity = O(n)
        int cs = 0, ms = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++)
        {
            cs += arr[i];
            if(cs < 0)
                cs = 0;
            ms = Math.max(ms,cs);
        }
        if (ms == 0)
        {
            ms = arr[0];
            for(int i =1; i<arr.length; i++)
                ms = Math.max(ms,arr[i]);
        }
        println(" >>> The maximum sub array sum = "+ms);
    }

    public static void main(String[] args)
    {
        int[] arr = {1,-2,6,-1,3};
        maxSubArr1(arr);
        println();
        maxSubArr2(arr);

        int[] arr2 = {-2,-3,4,-1,-2,1,5,-3};
        maxSubArr3(arr2);

        int[] arr1 = {-3,-6,-1,-4343};
        maxSubArr3(arr1);

    }
}
