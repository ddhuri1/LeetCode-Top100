class Solution
{
    public List<String> wordBreak(String s, List<String> wordDict)
    {
        if(s.length() > 100)
            return new ArrayList();
        List<String> ans = new ArrayList();
        dfsSearch(s, wordDict, ans, new StringBuilder());
        return ans;
    }
    
    private void dfsSearch(String s, List<String> wordDict, List<String> ans, StringBuilder path)
    {
        if(path.length() != 0)
            path.append(" ");    
        
        int size = wordDict.size();
        for(int i = 0; i < size; ++i)
        {
            String curWord = wordDict.get(i);
            if(s.startsWith(curWord))
            {
                StringBuilder newPath = new StringBuilder(path);
                newPath.append(curWord);
                if(s.equals(curWord))
                    ans.add(newPath.toString());
                else
                {
                    int nextStart = curWord.length();
                    dfsSearch(s.substring(nextStart), wordDict, ans, newPath);
                }
            }
        }
    }
}