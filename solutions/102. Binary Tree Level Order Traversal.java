/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>(); 
        if(root == null)
            return list;
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> li = new ArrayList<>();
            int len  = q.size();
            while(len != 0)
            {
                TreeNode temp = q.remove();
                li.add(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                len--;
            }
            list.add(li);
        }
        return list;
    }
}