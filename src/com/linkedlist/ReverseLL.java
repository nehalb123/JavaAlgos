package com.linkedlist;

public class ReverseLL {
    static ListNode nodes[] = new ListNode[15];
    static ListNode head;

    static void reverseLL(ListNode p){
        if(p.next == null){
            head = p;
            return;
        }
        reverseLL(p.next);
        ListNode q = p.next;
        q.next = p;
        p.next = null;
    }

    public static void main(String[] args) {
        nodes[0] = new ListNode(1);
        for(int i=1;i<15;i++){
            nodes[i] = nodes[i-1].add(i+1);
        }
        reverseLL(nodes[0]);
        System.out.println(head);
    }
}
