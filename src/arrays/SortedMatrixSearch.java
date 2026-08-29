package arrays;

import static util.printer.*;
public class SortedMatrixSearch
{
    // The matrix is sorted row-wise and column-wise

    public static boolean stairCaseSearch(int[][] arr, int key) // Time Complexity - O(n+m)
    {
        int row = 0, col = arr[0].length - 1;

        while(row < arr.length && col >= 0)
        {
            if(arr[row][col] == key){
                println("Found at ("+row+", "+col+")");
                return true;
            }
            else if(key < arr[row][col])
                col--;
            else
                row++;
        }

        println("Key NOT FOUND");
        return false;
    }

    public static void main(String[] args)
    {
        int[][] mat1 = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int key = 33;

        boolean k = stairCaseSearch(mat1,key);
        println(""+k);
    }
}
