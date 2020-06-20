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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        int len = 0;
        int m = n;
        if(head.next == null) return null;
        ListNode ptr = head;
        ListNode backup = head;
        while(n != 0)
        {
            ptr = ptr.next;
            n--;
            len++;
            if(ptr == null)
                len ++;
        }
        if(len == m+1)
        {
            head = head.next;
            return head;
        }
        while(ptr.next != null)
        {
            ptr = ptr.next;
            backup = backup.next;
        }
        backup.next = backup.next.next;
        return head;
    }
}