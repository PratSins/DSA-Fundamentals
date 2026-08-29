package arrays;

import static util.printer.*;
public class SpiralMatrix
{
    public static void printSpiral(int[][] mat)
    {
        // can be used for N x N and N x M matrices
        int sr, sc, er, ec;
        sr = sc = 0;
        er = mat.length -1;
        ec = mat[0].length - 1;
        int[] arr = new int[(mat.length) * (mat[0].length)];
        int k = 0;

        while(sr <= er && sc <= ec)
        {
            // top
            for(int j=sc; j <= ec; j++){
                arr[k] = mat[sr][j];
                k++;
            }

            // right
            for(int i=sr+1; i <= er; i++){
                arr[k] = mat[i][ec];
                k++;
            }

            // bottom
            for(int j=ec-1; j >= sc; j--)
            {
                if(sr == er)
                    break;

                arr[k] = mat[er][j];
                k++;
            }

            // left
            for(int i=er-1; i >= sr+1; i--)
            {
                if(sc == ec)
                    break;

                arr[k] = mat[i][sc];
                k++;
            }

            sc++;
            sr++;
            ec--;
            er--;
        }

        printArr(arr);
    }

    public static void main(String[] args)
    {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        printSpiral(mat);
    }
}