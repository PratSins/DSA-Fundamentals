import static util.printer.*;
public class QuickSort
{
    private static void quickSort(int[] arr, int si, int ei)
    {
        if(si >= ei)
            return;

        //pivot variable stores correct idx for pivot element
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }

    private static int partition(int[] arr, int si, int ei)
    {
        int pivot = arr[ei];
        int i = si-1; // makes space for elements smaller than pivot

        for(int j=si; j<ei; j++)
        {
            if(arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //place pivot at correct position
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[ei] = temp; //pivot's position need to change so (pivot = temp) won't work

        return i;
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }
    public static void main(String[] args)
    {
        int[] arr = {6, 3, 9, 5, 2, 8};
        quickSort(arr);
        printArr(arr);
    }
}