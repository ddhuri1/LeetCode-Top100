class Solution 
{
    public int myAtoi(String str) 
    {
        if(str == null || str.length() < 1) return 0;
        int i = 0;
        int sign = 1;
        while(i < str.length() &&str.charAt(i) == ' ')
            i++;
        if(i < str.length() && str.charAt(i) == '-')
        {
            sign = -1;
            i++;
        } 
        else if(i < str.length() && str.charAt(i) == '+')
        {
            sign = 1;
            i++;
        }
        double ans = 0;
    	while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') 
        {
            int value = str.charAt(i) - '0';
            ans = ans * 10 + value;
            i++;
        }
        ans = sign * ans;
        if(ans > Integer.MAX_VALUE )
            return Integer.MAX_VALUE ;
        if(ans < Integer.MIN_VALUE )
            return Integer.MIN_VALUE ;
        
        return (int)ans;
	}
}
