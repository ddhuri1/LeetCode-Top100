/*class Solution 
{
    public boolean isMatch(String s, String p) 
    {
        int m = s.length(), n = p.length();
        boolean[][] ans = new boolean[m+1][n+1];
        ans[0][0] = true;
        //if(p.length() > 0 && p.charAt(0) == '*') return false;   
        for(int j=1; j<=n; j++) 
        {
            if(p.charAt(j-1) == '*')  
                ans[0][j] = ans[0][j-1];
        }

        for(int i=1; i<m+1; i++) 
        {
            for(int j=1; j<n+1; j++) 
            {
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?')
                {
                    ans[i][j] = ans[i-1][j-1];
                } 
                else if( p.charAt(j-1) == '*') 
                {
                    ans[i][j] = ans[i][j-1] || ans[i-1][j];    
                } 
                
            }
        }
        return ans[m][n];
    }
}*/

class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        int i = 0;
        int j = 0;
        int star = -1;
        int match = 0;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            }else return false;
        }
        while (j < p.length() && p.charAt(j) == '*') j++;
        return j == p.length();
    }
}