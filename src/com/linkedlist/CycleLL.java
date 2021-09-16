package com.linkedlist;

/**
 * Detect if LL has cycle in it.
 *
 * Use slow and fast pointers to check for cycle
 *
 */
public class CycleLL {
    
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }

}
