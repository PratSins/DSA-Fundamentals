import static util.printer.*;
public class Largest_inArr
{
    static int findLarge(int[] arr)
    {
        int maxPos = 0;

        for(int i=1;i< arr.length;i++)
        {
            if(arr[maxPos] < arr[i])  // use >(greater than) to find smallest
                maxPos = i;
        }
        return maxPos;
    }
    static int find2ndLarge(int[] arr)
    {
        int maxPos = 0;
        int pos2 = -1; // For the 2nd largest

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxPos]) {
                pos2 = maxPos;
                maxPos = i;
            } else if (pos2 == -1 || arr[i] > arr[pos2]) {
                pos2 = i;
            }
        }

        return pos2;
    }
    static int find2ndSmall(int[] arr)
    {
        int minPos = 0;
        int pos2 = -1; // For the 2nd largest

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minPos]) {
                pos2 = minPos;
                minPos = i;
            } else if (pos2 == -1 || arr[i] < arr[pos2]) {
                pos2 = i;
            }
        }

        return pos2;
    }
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,234,456,8,9,10,19,312,44,66,-1,-2};

        int maxPos = findLarge(arr);
        println("The Largest no. in arr is at "+maxPos+" and no. is "+arr[maxPos]);


        int maxPos2 = find2ndLarge(arr);
        if (maxPos2 == -1) {
            println("There is no 2nd largest element.");
        } else {
            println("The 2nd Largest no. in arr is at "+maxPos2+" and no. is "+arr[maxPos2]);
        }

        int minPos2 = find2ndSmall(arr);
        if (maxPos2 == -1) {
            println("There is no 2nd smallest element.");
        } else {
            println("The 2nd smallest no. in arr is at "+minPos2+" and no. is "+arr[minPos2]);
        }
    }
}
