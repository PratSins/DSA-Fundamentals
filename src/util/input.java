package util;
import java.util.*;
public class input
{
    private static Scanner sc = new Scanner(System.in);
    public static int nextInt(){
        return sc.nextInt();
    }
    public static String nextWord(){
        return sc.next();
    }
    public static String nextStr(){
        return sc.nextLine();
    }
    public static double nextDouble(){
        return sc.nextDouble();
    }
    public static float nextFloat(){
        return sc.nextFloat();
    }
    public static char nextChar(){
        return sc.next().charAt(0);
    }
}
