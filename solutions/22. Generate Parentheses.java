class Solution 
{
    public List<String> generateParenthesis(int n) 
    {
        List<String> list = new ArrayList();
        String a = "";
        if(n == 1)
        {
            list.add("()");
            return list;
        }
        backtrack(list, a, n , 0 ,0);       
        return list;
    }
    public void backtrack(List<String> list, String s , int max, int open, int close)
    {
        if( s.length() == 2*max)
        {
            list.add(s);
            return;
        }
        if(open < max)
            backtrack(list, s + "(", max, open + 1, close);
        if(close < open)
            backtrack(list, s + ")" , max, open, close + 1);
    }
}