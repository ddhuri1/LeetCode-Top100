class Solution 
{
    public ListNode sortList(ListNode head) 
    {
        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        quickSort(dummyhead, null);
        return dummyhead.next;
    }
    public void quickSort(ListNode head, ListNode tail)
    {
        if (head.next == tail) return;
        if (head.next.next == tail) return;
        ListNode pivot = head.next;
        ListNode pivotptr = pivot;
        ListNode smallhead = new ListNode();
        ListNode smallptr = smallhead;
        ListNode largehead = new ListNode();
        ListNode largeptr = largehead;
        
        ListNode cur = pivot.next;
        while (cur != tail)
        {
            if (cur.val  < pivot.val) 
            {
                smallptr.next = cur;
                smallptr = smallptr.next;
            }
            else if (cur.val > pivot.val) 
            {
                largeptr.next = cur;
                largeptr = largeptr.next;
            }
            else 
            {
                pivotptr.next = cur;
                pivotptr = pivotptr.next;
            }
            cur = cur.next;
        }
        
        largeptr.next = tail;       
        pivotptr.next = largehead.next;
        smallptr.next = pivot;
        head.next = smallhead.next;
        
        quickSort(head, pivot);
        quickSort(pivotptr, tail);
        return;
    }
}
