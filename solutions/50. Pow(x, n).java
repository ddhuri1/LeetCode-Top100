class Solution 
{
    
    public double myPow(double x, int m) 
    {
        long n = m;
        if(n == 0) return 1;
        if(n == 1 || x == 1) return x;
        boolean neg = false;
        if(n < 0)
        {
            neg = true;
            n = Math.abs(n);
        } 
        double ans = 1.0;
        
        while(n != 0)
        {
            if((n & 1) == 1)
                ans = ans * x;
            x = x * x;
            n = n >> 1;
        }
        if(neg)
            ans = 1/ans;
        return ans;
    }
    
    
    
   /* public double myPow(double x, int n) 
    {
        long m = n > 0 ? n : -(long)n;
        double ans = 1.0;
        while (m != 0) 
        {
            if ((m & 1) == 1)
                ans *= x;
            x *= x;
            m >>= 1;
        }
        return n >= 0 ? ans : 1 / ans;
    }*/
}