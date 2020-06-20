class Solution 
{
    public int climbStairs(int n) 
    {
        int[] path = new int[n+1];
        if(n == 0) return 0;
        
        path[0] = 1;
        path[1] = 2;
        
        for(int i  = 2; i < n; i++)
        {           
            path[i] = path[i-1] + path[i-2];  
        }
        return path[n-1];
    }
}