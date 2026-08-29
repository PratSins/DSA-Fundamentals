import static util.printer.*;
public class MatrixTranspose
{
    public static int[][] transposeMat(int[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] transpose = new int[col][row];
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++) {
                transpose[j][i] =matrix[i][j];
            }
        }
        return transpose;
    }

    public static void main(String[] args)
    {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        println("Before:");
        printMatrix(mat);

        println();

        println("After:");
        mat = transposeMat(mat);
        printMatrix(mat);
    }
}