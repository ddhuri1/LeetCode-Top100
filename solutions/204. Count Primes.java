class Solution 
{
    public int countPrimes(int n) {    
       
        boolean[] isPrimes = new boolean[n];
        if(n <= 2) return 0;

        int count = n/2;
        for(int i = 3; i * i < n; i += 2)
        {
            if(isPrimes[i]) 
                continue;
            for(int j = i * i; j < n; j += 2*i) 
            {
                if(!isPrimes[j])
                {
                    isPrimes[j] = true;
                    count--;
                }
            }
        }
        return count;
    }
}