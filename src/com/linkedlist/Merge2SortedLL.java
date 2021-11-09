package com.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Merge2SortedLL {

    /**
     * If there are k such merges, we store the nodes in a heap.
     */
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(l1 != null && l2!=null){
            if(l1.data<=l2.data){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null){
            curr.next = l1;
        }else{
            curr.next = l2;
        }
        return dummyHead.next;
    }




    public static void main(String[] args) {
        int arr1[] = {1,2,3};
        int arr2[] = {1,3,4};
        //create the linked lists
        ListNode nodes1 = new ListNode(arr1[0]);
        ListNode nodes2 = new ListNode(arr2[0]);

        for (int i =1;i<arr1.length;i++){
             nodes1.add(arr1[i]);
        }

        for (int i =1;i<arr2.length;i++){
            nodes2.add(arr2[i]);
        }
        System.out.println(mergeTwoLists(nodes1,nodes2));

    }
}
