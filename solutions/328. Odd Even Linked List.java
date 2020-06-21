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
    public ListNode oddEvenList(ListNode head) 
    {
        if (head == null) return null;
        ListNode odd = head, even = head.next;
        ListNode eHead = even;
        while (even != null && even.next != null) 
        {
            odd.next = odd.next.next;
            even.next = even.next.next;
            even = even.next;
            odd = odd.next;
        }
        odd.next = eHead;
        return head;
    }
}