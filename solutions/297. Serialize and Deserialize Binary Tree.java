/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec 
{
    /* SLOW
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
         if(root==null)
			 sb.append("#,");
		 else
         {
			 sb.append(root.val + ",");
			 serialize(root.left);
			 serialize(root.right);
		 }
		 return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        String[] dataSplit = data.split(",");
        return traverse(new int[1],dataSplit);
    }
    
    private TreeNode traverse(int[] index, String[] dataSplit)
    {
		 if(dataSplit[index[0]].equals("#")) return null;
		 TreeNode root = new TreeNode(Integer.parseInt(dataSplit[index[0]]));
		 index[0]++; 
         root.left=traverse(index,dataSplit); 
		 index[0]++; 
         root.right=traverse(index,dataSplit);
		 return root;
	 }
     */
     public String serialize(TreeNode root) 
     {
        StringBuilder sb = new StringBuilder();
        sHelper(sb, root);
        return sb.toString();        
    }

    private void sHelper(StringBuilder sb, TreeNode node)
    {
        if (node == null)
        {
            if (sb.length() == 0) 
                return;
            sb.append('#').append(',');; 
            return;
        }        		
        sb.append(node.val).append(',');
        sHelper(sb, node.left);
        sHelper(sb, node.right);        	
    }    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        TreeNode node = null;
        if (data.length() == 0 || data == null) return node;
        String[] strs = data.split(",");
        int[] d = new int[1];
        return helper(strs, d);        
    }
    
    private TreeNode helper(String[] strs, int[] d)
    {
        String s = strs[d[0]++];
        if(s.equals("#"))
            return null;
        int val = Integer.parseInt(s);
        TreeNode node = new TreeNode(val);
        node.left = helper(strs, d);
        node.right = helper(strs, d);

        return node;
    }  
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));