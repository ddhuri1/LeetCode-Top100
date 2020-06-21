class Solution
{
    public int calculate(String s) 
    {
        int result = 0, curr = 0;
        if (s == null || s.length() == 0) return 0;
        int len = s.length(), i = 0, sign = 1, next = 0;
        while (i < len) 
        {
            char c = s.charAt(i);
            switch (c) 
            {
                case '+':
                    result += sign * curr;
                    curr = 0;
                    sign = 1;
                    i ++;
                    break;
                case '-':
                    result += sign * curr;
                    curr = 0;
                    sign = -1;
                    i ++;
                    break;
                case '*':
                    next = 0;
                    i ++;
                    while (i < len) 
                    {
                        c = s.charAt(i);
                        if (c == ' ') 
                            i ++;
                        else if (Character.isDigit(c))
                        {
                            next = next * 10 + c - '0';
                            i ++;
                        }
                        else 
                            break;
                    }
                    curr *= next;
                    break;
                case '/':
                    next = 0;
                    i ++;
                    while (i < len) 
                    {
                        c = s.charAt(i);
                        if (c == ' ') 
                            i ++;
                        else if (Character.isDigit(c)) 
                        {
                            next = next * 10 + c - '0';
                            i ++;
                        } 
                        else 
                            break;
                    }
                    curr /= next;
                    break;
                case ' ':
                    i ++;
                    break;
                default:
                    curr = curr * 10 + c - '0';
                    i ++;
                    break;
            }
        }
        result += sign * curr;
        return result;
    }
}