import java.util.*;
import static util.printer.*;
public class LinearSearch
{
    static int linearSearch(int[] arr, int key)
    {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key)
                return i;
        }

        return -1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7,8,9,10,19,312,44,66};
        print("Enter key to find: ");
        int key = sc.nextInt();

        int p = linearSearch(arr, key);
        if(p!=(-1))
            println("Position of key in the Array is "+p);
        else
            println("Key NOT FOUND!!!");

    }
}
