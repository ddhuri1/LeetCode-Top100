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
class Solution 
{
    public TreeNode sortedArrayToBST(int[] nums, int start, int ends)
    {
        if(start>ends) return null;
        if(start==ends) return new TreeNode(nums[start]);
        int middle = start + (ends-start) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBST(nums, start, middle-1);
        node.right = sortedArrayToBST(nums, middle+1, ends);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        if(nums==null || nums.length==0) return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
}