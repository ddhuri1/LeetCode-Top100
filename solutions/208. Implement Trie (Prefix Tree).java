class Trie 
{
    static TrieNode root;
    static class TrieNode
    {
        TrieNode[] children=new TrieNode[26];
        boolean isEndOfWord; 
    }
    /** Initialize your data structure here. */
    public Trie() 
    {
        root=new TrieNode(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        TrieNode curr = root; 
        int index=0;
        for(char c : word.toCharArray())
        {
            index = c - 'a'; 
            if(curr.children[index] == null)
               curr.children[index] = new TrieNode();
            curr = curr.children[index]; 
        }
        curr.isEndOfWord = true;     
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        TrieNode curr = root;
        int index = 0;
        for(char c : word.toCharArray())
        {
            index = c - 'a';
            if(curr.children[index] == null)
               return false; 
            curr = curr.children[index];
        }
        return curr != null && curr.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix)
    {
        TrieNode curr = root;
        int index = 0;
        for(char c : prefix.toCharArray())
        {
            index = c-'a';
            if(curr.children[index] == null)
               return false;
            curr = curr.children[index];
        }
        return curr != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */