package strings;

import static util.printer.*;
import java.util.*;
public class StringComparisonTry
{
    public static void main(String[] args)
    {
        String s1 = "Tony";
        String s2 = "Tony";
        String s3 = new String("Tony");

        if(s1 == s2)
            println("Equal");
        else
            println("NOT Equal");

        if(s1 == s3)
            println("Equal");
        else
            println("NOT Equal");

        Scanner sc = new Scanner(System.in);
        String s4, s5;
        println("Enter s4 and s5- ");
        s4 = sc.nextLine();
        s5 = sc.nextLine();
        if(s4 == s5)
            println("Equal");
        else
            println("NOT Equal");

        s5 = s4;
        if(s4 == s5)
            println("Equal");
        else
            println("NOT Equal");

        String s[] = {"prat", "prat"};
        if(s[0] == s[1])
            println("Equal");
        else
            println("NOT Equal");
    }
}
