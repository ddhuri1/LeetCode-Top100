class Solution 
{
    public int maxProfit(int[] prices) 
    {
        if(prices == null || prices.length == 0) return 0;
        int size = prices.length;
        int min = prices[0];
        int r[] = new int[size+1];
        r[0] = 0;
        for(int i = 1; i< size ; i++)
        {
            r[i] = r[i-1];
            if(prices[i] < min)
                min = prices[i];
            if(r[i-1] <  prices[i] - min)
                r[i] = prices[i] - min;
        }
        return r[size - 1];
    }
}