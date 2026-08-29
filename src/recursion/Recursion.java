import static util.printer.*;
public class Recursion
{
    public static int fibonacci(int n)
    {
        if(n==0 || n==1)
            return n;
        if(n<0)
            return -1;

        return fibonacci(n-1) + fibonacci(n-2);
    }

    private static boolean isSort(int[] arr, int i)
    {
        if (i == arr.length-1)
            return true;

        if (arr[i] > arr[i + 1])
            return false;

        return isSort(arr, i + 1);
    }
    public static boolean isSorted(int[] arr) {
        return isSort(arr, 0);
    }

    private static int firstOccur(int[] arr, int key, int i) {
        if (i == arr.length)
            return -1;
        if (arr[i] == key) {
            return i;
        }
        return firstOccur(arr, key, i + 1);
    }
    public static int firstOccurrence(int[] arr, int key){
        return firstOccur(arr, key, 0);
    }

    private static int lastOccur(int[] arr, int key, int i) {
        if (i == -1)
            return -1;
        if (arr[i] == key) {
            return i;
        }
        return lastOccur(arr, key, i - 1);
    }
    public static int lastOccurrence(int[] arr, int key){
        return lastOccur(arr, key, arr.length-1);
    }

    public static int power(int x, int n) // returns x^n
    {
        if(n==0)
            return 1;

        int halfPowerSq = power(x, n/2) * power(x, n/2);

        if(n%2 != 0)
            halfPowerSq *= x;

        return halfPowerSq;
    }

    public static void main(String[] args)
    {
        println("10th no. in fibonacci series is "+fibonacci(10)+"\n");

        int[] arr1 = {10, 34, 87, 122, 134};
        int[] arr2 = {10, 34, 87, 12, 134};

        println("Is arr1 sorted ??   ---  "+isSorted(arr1));
        println("Is arr2 sorted ??   ---  "+isSorted(arr2));
        println();

        int[] arr3 = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        int pos = firstOccurrence(arr3, 5);
        println("The 1st occurrence of 5 in arr3 = "+pos);
        pos = lastOccurrence(arr3, 5);
        println("The last occurrence of 5 in arr3 = "+pos);
        println();

        int k = power(2,9);
        println(""+k);
    }
}
