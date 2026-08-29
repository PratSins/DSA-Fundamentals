import static util.printer.*;
import static util.input.*;
import java.math.*; // For in-built HCF function
public class HCF_LCM
{
    public static int HCF_inbuilt(int a, int b)
    {
        BigInteger x, y, hcf;
        x = new BigInteger(String.valueOf(a));
        y = new BigInteger(String.valueOf(b));

        hcf = x.gcd(y);
        return Integer.parseInt(String.valueOf(hcf));
    }
    // Time Complexity -- O(log n)
    public static int HCF(int a, int b)
    {
        if( a==0 && b==0)
            return 1;
        if(a == 0)
            return b;
        if(b == 0)
            return a;
        // No need for swapping a and b as they will get the result but with 1 extra iteration

        if(a%b == 0)
            return b;
        return HCF(b, a%b);
    }
    public static void main(String[] args)
    {
        println("Enter 2 no.:");
        int a = nextInt();
        int b = nextInt();
        int h = HCF(a,b);
        int lcm = (int) ((double) (a*b)/h);
        println("HCF of the "+h);
        println("LCM of the "+lcm);
    }
}