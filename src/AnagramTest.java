import java.util.Arrays;
public class AnagramTest
{
    static boolean test(String str1, String str2)
    {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.length() != str2.length())
            return false;

        char[] str1charArray = str1.toCharArray();
        char[] str2charArray = str2.toCharArray();

        Arrays.sort(str1charArray);
        Arrays.sort(str2charArray);

        return Arrays.equals(str1charArray, str2charArray);
    }
    public static void main(String[] args) {
        String str1 = "earth";
        String str2 = "heart";

        boolean result = test(str1,str2);
        if (result)
            System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
        else
            System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");

    }
}