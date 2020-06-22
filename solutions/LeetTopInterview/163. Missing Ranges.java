class Solution 
{
    public List<String> findMissingRanges(int[] nums, int lower, int upper) 
    {
        long lo=(long) lower;
        long hi=(long) upper;
        List<String> res=new ArrayList<>();
        int len=nums.length;
        if(nums==null || len==0)
        {
            AD(res,lo-1,hi+1);
            return res;
        }
        AD(res,lo-1,nums[0]);
        for(int i=1;i<len;i++)
        {
            AD(res,nums[i-1],nums[i]);
        }
        AD(res,nums[len-1],hi+1);
        return res;
        
    }
    private void AD(List<String> res, long lo, long hi)
    {
        if(lo==hi)
            return;
        else if(lo+1==hi)
            return;
        else if(lo+1==hi-1)
            res.add(String.valueOf(lo+1) );
        else
        {
            StringBuilder sb=new StringBuilder();
            sb.append(String.valueOf(lo+1) );
            sb.append("->");
            sb.append(String.valueOf(hi-1) );
            res.add(sb.toString() ); 
        }
        
    }
}