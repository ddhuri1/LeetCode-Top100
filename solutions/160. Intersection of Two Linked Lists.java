/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null) return null;
        int aLen = getListLength(headA);
        int bLen = getListLength(headB);
        if (aLen < bLen) 
            return getIntersectionNode(headB, headA);
        ListNode pA = headA, pB = headB;
        for (int i = 0; i < aLen - bLen; i++) 
            pA = pA.next;
        while (pA != null && pB != null) 
        {
            if (pA == pB) 
                return pA;
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
    
    private int getListLength(ListNode head) 
    {
        int len = 0;
        while (head != null) 
        {
            len++;
            head = head.next;
        }
        return len;
    }
}