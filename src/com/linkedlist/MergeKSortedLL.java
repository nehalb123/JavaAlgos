package com.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLL {

    static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>((l1,l2) -> {
            return l1.data-l2.data;
        });
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,3};
        int arr2[] = {1,3,4};
        int arr3[] = {2,5,6};
        ListNode nodes1[] = new ListNode[arr1.length];
        ListNode nodes2[] = new ListNode[arr2.length];
        ListNode nodes3[] = new ListNode[arr3.length];
        nodes1[0] = new ListNode(arr1[0]);
        for (int i =1;i<arr1.length;i++){
            nodes1[i] = nodes1[i-1].add(arr1[i]);
        }
        nodes2[0] = new ListNode(arr2[0]);
        for (int i =1;i<arr2.length;i++){
            nodes2[i] = nodes2[i-1].add(arr2[i]);
        }
        nodes3[0] = new ListNode(arr3[0]);
        for (int i =1;i<arr3.length;i++){
            nodes3[i] = nodes3[i-1].add(arr3[i]);
        }
        ListNode[] lists = {nodes1[0], nodes2[0], nodes3[0]};

        System.out.println(mergeKLists(lists));
    }
}
