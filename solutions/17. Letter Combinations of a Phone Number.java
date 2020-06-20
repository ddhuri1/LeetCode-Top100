class Solution 
{
    String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) 
    {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        process(digits,result, new StringBuilder(), 0);
        return result;
    }

    public void process(String digits,List<String> result, StringBuilder sb,  int index) 
    {
        if(index == digits.length()) 
        {
            result.add(sb.toString());
            return;
        }
    
        String str = chars[digits.charAt(index) - '0'];
        for(char c : str.toCharArray()) 
        {
            sb.append(c);
            process(digits,result, sb,  index + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}