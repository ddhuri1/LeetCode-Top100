class Solution 
{
    public String longestCommonPrefix(String[] strs) 
    {   
        
        if (strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        for (int i = 0; i < strs[0].length() ; i++)
        {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) 
            {
                if ( i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);             
            }
        }
        return strs[0];
        
        
        /* DIVIDE AND CONQUER
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int l = strs.length;
        String[] strs1 = new String[l/2];
        String[] strs2 = new String[l - l/2];
        for (int i = 0; i < l/2; i++)
            strs1[i] = strs[i];
        for (int i = l/2; i < l; i++) 
            strs2[i-l/2] = strs[i];
        String s1 = longestCommonPrefix(strs1);
        String s2 = longestCommonPrefix(strs2);
        int i = 0;
        while (i<s1.length() && i <s2.length() && s1.charAt(i) == s2.charAt(i)) 
            i++;
        return s1.substring(0, i);
        */
    }
}