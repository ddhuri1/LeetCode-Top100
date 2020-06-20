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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        /*
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 0; i< lists.length; i++)
        {
            ListNode ptr = lists[i];
            while(ptr != null)
            {
                minHeap.add(ptr.val);
                ptr = ptr.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(!minHeap.isEmpty())
        {
            ListNode temp = new ListNode(minHeap.remove());
            head.next = temp;
            head = head.next;
        }
        return res.next;
        */
        
        /*
        ListNode res = new ListNode(0);
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0]; 
        res =  mergeTwoLists(lists[0], lists[1]);
        for(int i = 2; i< lists.length; i++)
        {
            res = mergeTwoLists(res, lists[i]);
        }
         return res;
    }
    
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
    
    */
        
        return mL(lists, 0, lists.length - 1);
    }
    
    private ListNode mL(ListNode[] lists, int l, int r) {
        if (r < l) return null;
        if (r == l) return lists[r];
        
        int mid = (l + r) / 2;
        ListNode a = mL(lists, l, mid), b = mL(lists, mid + 1, r);
        ListNode dmHead = new ListNode(0), cur = dmHead;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a != null) ? a : b;
        
        return dmHead.next;
    }
}