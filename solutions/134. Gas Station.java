class Solution 
{
    
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        if(gas == null || gas.length == 0) return -1;
        int start = 0;
        int tank = 0;
        for(int i = 0; i < gas.length; i++)
            tank += gas[i] - cost[i];
        if(tank < 0)
            return -1;

        int prevTotal = 0;
        for(int i = 0; i < gas.length; i++)
        {
            int curTotal = gas[i] - cost[i];
            if(prevTotal + curTotal < 0)
            {
                start = i + 1;
                prevTotal = 0;
            }
            else prevTotal += curTotal;
        }

        return start;
    }
}