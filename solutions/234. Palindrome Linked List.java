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
    public boolean isPalindrome(ListNode nhead) 
    {
        if(nhead == null || nhead.next == null) return true;
        if(nhead.next.next == null && nhead.val == nhead.next.val) return true;
        else if(nhead.next.next == null && nhead.val != nhead.next.val) return false;
        ListNode end = nhead, mid = nhead;
        while(end != null && end.next != null)
        {
            end = end.next.next;
            mid = mid.next;
        }
        
        if(end != null)
            mid = mid.next;
        
        mid = reverse(mid);
        end = nhead;
        
        while(mid != null)
        {
            if(mid.val != end.val)
                return false;
            mid = mid.next;
            end = end.next;
        }
        return true;
        
    }
    
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        while (head != null) 
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}