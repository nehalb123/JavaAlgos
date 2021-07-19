package com.linkedlist;

/**
 * Find the intersection node of two linked lists
 * Rating: ⭐ ⭐ ⭐ ⭐
 */
public class IntersectionOfLL {

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a_ptr = headA;
        ListNode b_ptr = headB;
        //Grabbing the difference in the length
        while(a_ptr != b_ptr){
            if(a_ptr != null){
                a_ptr = a_ptr.next;
            }else{
                a_ptr = headB;
            }
            if(b_ptr != null){
                b_ptr = b_ptr.next;
            } else{
                b_ptr = headA;
            }
        }
        return a_ptr;
    }

}
