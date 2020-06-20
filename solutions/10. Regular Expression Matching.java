class Solution 
{
    
    public boolean isMatch(String s, String p) 
    {    
        int m = s.length(), n = p.length();
        boolean[][] ans = new boolean[m+1][n+1];
        ans[0][0] = true;
        if(p.length() > 0 && p.charAt(0) == '*') return false;

        for(int j=1; j<n+1; j++) {
            if(p.charAt(j-1) == '*') ans[0][j] = ans[0][j-2];
        }

        for(int i=1; i<m+1; i++) 
        {
            for(int j=0; j<n+1; j++) 
            {
                if(j > 0 && (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')) 
                {
                    ans[i][j] = ans[i-1][j-1];
                } 
                else if(j > 0 && p.charAt(j-1) == '*') 
                {
                    ans[i][j] = ans[i][j-2];
                    if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') 
                    {
                        ans[i][j] |= ans[i-1][j];    
                    }
                } 
                else 
                {
                    ans[i][j] = false;
                }
            }
        }
        return ans[m][n];
    } 
}
    
    
    

