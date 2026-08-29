package util;

public class printer
{
    public static void print(String str) { System.out.print(str); }
    public static void print(StringBuilder str) { System.out.print(str); }
    public static void println(StringBuilder str) { System.out.println(str); }
    public static void println(String str) { System.out.println(str); }
    public static void println() { System.out.println(); }

    public static void printArr(int[] arr){
        print("[ ");
        for(int x: arr)
            print(x+" ");
        println("]");
    }
    public static void printArr(Integer[] arr){
        print("[ ");
        for(int x: arr)
            print(x+" ");
        println("]");
    }
    public static void printMatrix(int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                print(matrix[i][j] +"  ");
            }
            println();
        }
    }
}
