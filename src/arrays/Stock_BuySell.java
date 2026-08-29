package arrays;

import static util.printer.*;
public class Stock_BuySell
{
    static int profit(int[] p)
    {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<p.length; i++)
        {
            if(buyPrice < p[i]){
                int profit = p[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
            else
                buyPrice = p[i];
        }

        return maxProfit;
    }
    public static void main(String[] args)
    {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int k = profit(prices);

        println("The maximum profit that can be made = "+k);
    }
}
