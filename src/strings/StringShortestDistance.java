package strings;

import static util.printer.*;
public class StringShortestDistance
{
    public static double getDisplacement(String str)
    {
        int x, y;
        x=y=0;
        int len = str.length();

        for(int i=0; i<len; i++)
        {
            char d = str.charAt(i);
            if(d == 'W')
                x--;
            else if(d == 'E')
                x++;
            else if(d == 'S')
                y--;
            else if(d== 'N')
                y++;
            else{

            }
        }
        double dt = Math.sqrt((x*x) + (y*y));
        return dt;
    }
    public static void main(String[] args)
    {
        String path = "WNEENESENNN";
        println("The displacement from origin is "+getDisplacement(path));
    }
}
