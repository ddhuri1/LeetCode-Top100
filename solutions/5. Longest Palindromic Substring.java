class Solution 
{
    
    public String longestPalindrome(String s) 
    {
	    if(s==null || s.length() < 1)
            return "";
 
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            int len1 = midExpand(s, i, i);
            int len2 = midExpand(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if(len > end - start)
            {
                start = i - ((len - 1) /2);
                end = i + (len / 2);
            }
        }

        return s.substring(start , end + 1);
    }

    public int midExpand(String s, int left, int right) 
    {
        if(s==null || left > right)
            return 0;
        
        while (left >= 0 && right < s.length()  && s.charAt(left) == s.charAt(right)) 
        {
            left--;
            right++;
        }
        return right - left - 1;
    }
   
    
    /*public String longestPalindrome(String s) 
    {
        StringBuilder input1 = new StringBuilder(); 
        input1.append(s);
        Stack<Character> stack = new Stack<>(); 
        
        input1 = input1.reverse(); 
        char[] X = s.toCharArray(); 
        char[] Y = input1.toCharArray();  
        int m = X.length; 
        int n = Y.length;
        int c[][] = new int[m + 1][n + 1];
        int L[][] = new int[m + 1][n + 1]; 
         for (int i = 0; i <= m; i++) 
         { 
            for (int j = 0; j <= n; j++) 
            { 
                if (i == 0 || j == 0) 
                    L[i][j] = 0; 
                else if (X[i - 1] == Y[j - 1]) 
                    L[i][j] = L[i - 1][j - 1] + 1; 
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]); 
            } 
        }
        int i = X.length; 
        int j = Y.length;
        while (i > 0 && j > 0)
        {
            if(a.charAt(i-1) == b.charAt(j-1))
             {
                     stack.push(a.charAt(i-1));
                     i--;
                     j--;
             }                
             else 
            {
                 if (c[i-1][j] > c[i][j-1]) 
                     i--; 
                 else
                     j--;
             } 
        }
        int size = c[m-1][n-1];
        for (i = 0; i < n; i++) 
        {  
            char y = (char) stack.pop(); 
            str.setCharAt(i,y); 
        } 
        return str;
    }*/
}