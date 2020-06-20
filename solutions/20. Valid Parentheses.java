class Solution 
{
    public boolean isValid(String s) 
    {
        Stack<Character> stack = new Stack<Character>();
        if(s.length() < 1 || s.isEmpty()) return true;
        if(s.trim().isEmpty()) return false;
        if(s.length() % 2 != 0) return false;
        char[] arr = s.toCharArray();
        for(char c : arr) 
        {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);                         
            else 
            {
                if(stack.isEmpty())                     
                    return false;
                char sym = stack.pop();
                if(c == ')' && sym == '(')  continue;
                if(c == '}' && sym == '{')  continue;
                if(c == ']' && sym == '[')  continue;
                else
                    return false;                       
            }
        }
        return stack.isEmpty(); 
    }
}