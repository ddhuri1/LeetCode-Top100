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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode oldList = new ListNode(0);
        ListNode newList = oldList;
        int carry = 0;
        while(l1 != null || l2 != null)
        {
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;
            int sum = a + b + carry;            
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            newList.next = new ListNode(sum % 10);
            newList = newList.next;
        }
        if(carry > 0)
        {
            newList.next = new ListNode(carry);
        }
        return oldList.next;
    }
}