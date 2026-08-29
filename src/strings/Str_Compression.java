import static util.printer.*;
public class Str_Compression
{
    public static String compress(String s)
    {
        String ns = "";
        for(int i=0;i<s.length();i++)
        {
            int count = 1;
            ns += s.charAt(i);
            while(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                count++;
                i++;
            }
            if(count>1)
                ns+=count;
        }
        return ns;
    }
    public static void main(String[] args)
    {
        String s = "aaabbcccdd";
        println(s);
        println(compress(s));
        s="abcd";
        println(s);
        println(compress(s));
    }
}
