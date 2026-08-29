package divideandconquer;

import static util.printer.*;
public class MergeSort
{
    private static void mergeSort(int[] arr, int start, int end)
    {
        if(start >= end)
            return;
        int mid = start + (end - start)/2; //  = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        merge(arr, start, mid, end);
    }

    //merge method to merge the sorted parts
    private static void merge(int[] arr, int start, int mid, int end)
    {
        int[] temp = new int[end-start+1];
        int i = start; //idx for 1st sorted part
        int j = mid+1; //idx for 2nd sorted part
        int k = 0; //idx for temp;

        while(i <= mid && j <= end)
        {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //for leftover elements of 1st sorted part
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        //for leftover elements of 2nd sorted part
        while(j <= end) {
            temp[k++] = arr[j++];
        }

        //copy temp to original array
        for(k=0, i=start; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }
    public static void main(String[] args)
    {
        int[] arr = {6, 3, 9, 5, 2, 8};
        mergeSort(arr);
        printArr(arr);
    }
}