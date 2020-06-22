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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
    {
        if (p.right != null)
        {
            p = p.right;
            while (p.left != null)
                p = p.left;
            return p;
        }
        TreeNode successor = null;
        while (root != null)
        {
            if(root.left == null)
                root = root.right;
            else 
            {
                TreeNode pred = root.left;
                while (pred.right != null && pred.right != root)
                    pred = pred.right;
                if (pred.right == null)
                {
                    pred.right = root;
                    root = root.left;
                } 
                else 
                {
                    if (root.val > p.val)
                    {
                        successor = root;
                        break;
                    }
                    root = root.right;
                    pred.right = null;
                }
            }
        }
        return successor;
    }
}