package recursion;

import static util.printer.*;
public class RemoveDuplicatesInStr
{
    private static void unique(String str, int idx, StringBuilder newStr, boolean[] map)
    {
        if(idx == str.length())
            return;

        char currChar = str.charAt(idx);
        if(map[currChar - 'a'])
            unique(str, idx+1, newStr, map);
        else{
            map[currChar - 'a'] = true;
            unique(str, idx+1, newStr.append(currChar), map);
        }
    }
    public static String removeDuplicates(String str)
    {
        boolean[] map = new boolean[26];
        StringBuilder newStr = new StringBuilder("");
        unique(str, 0, newStr, map);

        return newStr.toString();
    }

    public static void main(String[] args)
    {
        String s = "appnnacollege";
        print(removeDuplicates(s));
    }
}
