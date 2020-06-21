/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/* Slow
class Solution 
{
    PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
    int capacity;
    public int kthSmallest(TreeNode root, int k)
    {
        capacity = k;
        inorder(root);
        return pq.poll();
    }
    
    public void inorder(TreeNode node) 
    {
        if(node == null) 
            return;
        inorder(node.left);
        pq.add(node.val);
        if(pq.size() > capacity) 
            pq.poll();
        inorder(node.right);
    }
}

*/

class Solution
{
    public int kthSmallest(TreeNode root, int k) 
    {
        if(k < 0)
            return -1;
        List<Integer> list = new ArrayList<>(k);
        findSmallest(root, k, list);
        return list.get(list.size() - 1);
    }
    
    private void findSmallest(TreeNode root, int k, List<Integer> list)
    {    
        if(root == null)
            return;   
        findSmallest(root.left, k, list);
        if(list.size() < k)
            list.add(root.val);
        findSmallest(root.right, k, list);
    }
}