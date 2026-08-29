package recursion;

/*
    Friends Pairing Problem

    Given n friends, each one can remain single or can be paired up with some other
    friend. Each friend can be paired only once. Find out the total number of ways in
    which friends can remain single or can be paired up.

* */

import static util.printer.*;
import static util.input.*;
public class FriendPairing
{
    public static int pair(int n)
    {
        if(n == 1 || n == 2)
            return n;
        return pair(n-1) + (n-1) * pair(n-2);
    }
    
    public static void main(String[] args)
    {
        print("Enter the no. of friends present\n -> ");
        int n = nextInt();
        int totalWays = pair(n);

        println("\nThe total no. of ways which friends can be paired = "+totalWays);
    }
}
