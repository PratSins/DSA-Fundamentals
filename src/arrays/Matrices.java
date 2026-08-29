package arrays;

import static util.printer.*;
public class Matrices
{
    public static void diagonalSum(int[][] arr)
    {
        if( arr.length != arr[0].length){
            println("Wrong matrix passed");
            return;
        }
        int len = arr.length;
        int pds = 0;
        int sds = 0;

        for(int i=0; i<=len-1; i++){
            pds += arr[i][i];
            sds += arr[i][len-1-i];
        }

        println("Primary diagonal sum = "+pds);
        println("Secondary diagonal sum = "+sds);

        int sum = pds+sds;
        if(len%2 != 0)
            sum -= arr[len/2][len/2];

        println("Total diagonal sum = "+sum);
    }
    public static void main(String[] args)
    {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        diagonalSum(mat);

        println();

        int[][] mat1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        diagonalSum(mat1);
    }
}