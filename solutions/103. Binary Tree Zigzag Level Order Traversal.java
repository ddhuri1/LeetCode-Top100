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
    /*
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        boolean left = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> tmp = new ArrayList<>();
            int len = q.size();
            for(int i = 0; i < len; i++)
            {
                TreeNode temp = q.remove();
                if(left) 
                    tmp.add(temp.val);
                else 
                    tmp.add(0 , temp.val);
                
                if(temp.left != null) 
                    q.add(temp.left);
                if(temp.right != null) 
                    q.add(temp.right);
            }
            left = !left;
            list.add(tmp);
        }
        return list;
    }
    */
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> list = new ArrayList();
        travel(list, 0, root);
        return list;
    }
    private void travel(List<List<Integer>> list, int level, TreeNode cur) 
    {
        if (cur == null) return;
        if (list.size() <= level) 
            list.add(new ArrayList<Integer>());
        if (level % 2 == 0)
            list.get(level).add(cur.val);
        else 
            list.get(level).add(0, cur.val);
        travel(list, level + 1, cur.left);
        travel(list, level + 1, cur.right);
    }
}