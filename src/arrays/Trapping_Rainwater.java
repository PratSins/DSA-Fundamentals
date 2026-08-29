package arrays;

import static util.printer.*;
// LeetCode - Hard Problem

public class Trapping_Rainwater
{
    public static int trappedRainWater(int[] h) // Time Complexity = O(n)
    {
        int trappedWater = 0, len = h.length;

        int[] leftMax = new int[len];
        leftMax[0] = h[0];
        for(int i = 1; i < len; i++)
            leftMax[i] = Math.max(h[i], leftMax[i-1]);

        int[] rightMax = new int[len];
        rightMax[len-1] = h[len-1];
        for(int i=len-2; i>=0; i--)
            rightMax[i] = Math.max(h[i], rightMax[i+1]);

        for(int i=0; i<len; i++)
        {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += (waterLevel - h[i]);
        }

        return trappedWater;
    }

    public static int trappedRainWater2(int[] h) // FASTER ALGORITHM THAN THE PREVIOUS ONE
    {
        int l = 0, r = h.length - 1;
        int leftMax = h[l], rightMax = h[r];

        int res = 0;

        while(l < r)
        {
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, h[l]);
                res += (leftMax - h[l]);
            }
            else{
                r--;
                rightMax = Math.max(rightMax, h[r]);
                res += (rightMax - h[r]);
            }
        }

        return res;
    }
    public static void main(String[] args)
    {
//        int[] height = {7,6,5,4,3,2,1};
//        int[] height = {1,2};
        // the above two are corner cases that don't affect the original algorithm anyway.
        int[] height = {4, 2, 0, 6, 3, 2, 5};
        int wl = trappedRainWater2(height);

        println("Trapped Rain water in the bars = "+wl);

    }

}
