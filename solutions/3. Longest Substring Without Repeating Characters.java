class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length() == 0) return 0;
        int count = 0;
        int temp = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() ; i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                temp = Math.max(temp, map.get(s.charAt(i)));
            }
            count = Math.max(count, i - temp + 1);
            map.put(s.charAt(i) , i + 1);
        }
        return count;
    }
}