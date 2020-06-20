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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(69);
        ListNode res = head;
        ListNode temp;
        while(l1 != null && l2 != null)
        {
            
            if(l1.val <= l2.val)
            {
                temp =  new ListNode(l1.val);
                l1 = l1.next;
            }
            else
            {
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }
            res.next = temp;
            res = res.next;
        }
        if(l1 != null)
            res.next = l1;
        if(l2 != null)
            res.next = l2;
        return head.next;
    }
}