class Solution 
{
    
    TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) 
    {
        List<String> found = new ArrayList<>();
        if (words==null || words.length==0 || board==null || board.length==0) return found;
        for (String word : words) 
            addWord(word);
        int m=board.length, n=board[0].length;
        
        for (int i=0; i<m; i++) 
            for (int j=0; j<n; j++) 
                search(board, root, i, j, found);
        return found;
    }
    
    private void search(char[][] board, TrieNode node, int i, int j, List<String> found)
    {
        char c = board[i][j];
        if (c=='#' || node.children[c-'a']==null) return;
        node = node.children[c-'a'];
        if (node.word!=null) 
        {
            found.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i > 0) search(board,node,i-1,j,found);
        if (j > 0) search(board,node,i,j-1,found);
        if (i < board.length - 1) search(board, node, i + 1, j, found);
        if (j < board[0].length - 1) search(board, node, i, j + 1, found);
        board[i][j] = c;
    }
    
    class TrieNode 
    {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    
    private void addWord(String word)
    {
        TrieNode node = root;
        for (char c : word.toCharArray())
        {
            if (node.children[c-'a'] == null)
                node.children[c-'a'] = new TrieNode();
            node = node.children[c-'a'];
        }
        node.word = word;
    }
    
}