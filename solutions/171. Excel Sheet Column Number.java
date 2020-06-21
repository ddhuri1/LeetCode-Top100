class Solution 
{
    public int titleToNumber(String s)
    {
        int num = 0;
        int len = s.length();
        for(int i =0;i<len;i++)
        {
             int d = s.charAt(i)-'A' + 1;
             num += d * Math.pow(26, len - i - 1);
        }     
        return num;
    }
}
