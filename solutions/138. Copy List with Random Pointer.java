/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution 
{
    public Node copyRandomList(Node head) 
    {
        if(head == null) return head;
        Node ptr = head;
        while(ptr != null)
        {
            Node newnode = new Node(ptr.val);
            newnode.next = ptr.next;
            ptr.next = newnode;
            ptr = newnode.next;
        }
        ptr = head;
        while(ptr != null)
        {
            ptr.next.random = (ptr.random != null)? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        
        Node oriHead = head;
        Node newHead = head.next;
        Node ptrnew = head.next;
        while(oriHead != null)
        {
            oriHead.next = oriHead.next.next;
            newHead.next = (newHead.next != null)? newHead.next.next : null;
            oriHead = oriHead.next;
            newHead = newHead.next;
        }
        
        return ptrnew;
    }
}