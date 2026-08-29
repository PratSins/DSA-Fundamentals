package recursion;

/*
* Print all binary strings of size N without consecutive ones.
* PayTM
* */

import static util.printer.*;
import static util.input.*;
public class BinaryStrings
{
    public static void printBinStrings(int n, int lastPlace, String str)
    {
        if(n == 0) {
            println(str);
            return;
        }

        printBinStrings(n-1, 0, str+"0");

        if(lastPlace == 0) {
            printBinStrings(n-1, 1, str+"1");
        }
    }
    public static void printBinStrings(int n) {
        printBinStrings(n, 0, "");
    }
    public static void main(String[] args)
    {
        print("Enter a no. \n -> ");
        int n = nextInt();
        printBinStrings(n);
    }
}
