
class TrieNode 
{
    boolean isWord;
    TrieNode[] children;
    public TrieNode ()
    {
        children = new TrieNode[26];
    }
}
class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        TrieNode root = buildTrie(wordDict);
        int[] visited = new int[s.length()];
        
        return dfs(root, s, 0, visited);
    }
    
    private TrieNode buildTrie(List<String> wordDict) 
    {
        TrieNode root = new TrieNode();
        
        for (String word: wordDict) 
        {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) 
            {
                char curr = word.charAt(i);
                if (node.children[curr - 'a'] == null)
                    node.children[curr - 'a'] = new TrieNode();
                node = node.children[curr - 'a'];
            }
            node.isWord = true;
        }
        
        return root;
    }
    
    private boolean dfs(TrieNode root, String s, int index, int[] visited)
    {
        TrieNode node = root;
        for (int i = index; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (node.children[curr - 'a'] == null)
                    return false;
            if (visited[i] == 0) 
            {
                if (node.children[curr - 'a'].isWord == true) 
                {
                    visited[i] = 1;
                    if(i == s.length() - 1)
                        return true;
                    if(dfs(root, s, i + 1, visited))
                        return true;
                }
            }
            node = node.children[curr - 'a'];
        }
        return false;
    }
}



/* SLOWER
public class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        Set<String> wordDictSet=new HashSet(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) 
        {
            for (int j = 0; j < i; j++) 
            {
                if (dp[j] && wordDictSet.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
*/