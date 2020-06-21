/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public ListNode reverseList(ListNode head) 
    {
        ListNode temp = new ListNode(0);
        if(head == null || head.next == null) return head;
        ListNode curr = head.next;
        head.next = null;
        while(temp != null)
        {
            temp = curr.next;
            curr.next = head;
            head = curr;
            curr = temp;
        }
        return head;
    }
}