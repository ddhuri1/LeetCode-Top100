class Solution
{
    public String largestNumber(int[] nums) 
    {
        if (nums == null || nums.length == 0) return "0";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) 
            strs[i] = String.valueOf(nums[i]);        
        Arrays.sort(strs, new Comparator<String>()
        {
            public int compare(String a, String b) 
            {
                int p = 0;
                int q = 0;
                while(true) 
                {
                    if (p == a.length() && q == b.length()) 
                        return 0;
                    else if (p == a.length()) 
                        p = 0;
                     else if (q == b.length())
                        q = 0;
                    else if (a.charAt(p) > b.charAt(q)) 
                        return -1;
                    else if (a.charAt(p) < b.charAt(q)) 
                        return 1;
                    else
                    {
                        p++;
                        q++;
                    }
                }
            }
        });
        
        StringBuilder sb = new StringBuilder();
        if (strs[0].equals("0")) 
            return "0";
        for (String str : strs) 
            sb.append(str);
        return sb.toString();  
    }
    
    
}