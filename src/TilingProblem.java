/*
* Tiling Problem
    Given a "2 x n" board and tiles of size "2 x 1", count the number of
    ways to tile the given board using the 2 x 1 tiles.
    (A tile can either be placed horizontally or vertically)
* */
import static util.printer.*;
public class TilingProblem
{
    public static int getTiles(int n)
    {
        if (n<0)
            return 0;
        if(n == 0 || n == 1)
            return 1;

        int verticalWays = getTiles(n-1);
        int horizontalWays = getTiles(n-2);

        int totalWays = verticalWays + horizontalWays;
        return totalWays;
    }
    public static void main(String[] args)
    {
        println(""+getTiles(5));
        println(""+getTiles(-1));
    }
}
