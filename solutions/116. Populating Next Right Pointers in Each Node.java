/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution
{
    public Node connect(Node root) 
    {
        if(root == null) return root;
        Node node = root;
        while(root.left!=null){
            Node leftmost = root;
            while(leftmost!=null){
                leftmost.left.next = leftmost.right;
                if(leftmost.next!=null){
                    leftmost.right.next = leftmost.next.left;
                }
                leftmost = leftmost.next;
            }
            root = root.left;
        }
        return node;
    }
}