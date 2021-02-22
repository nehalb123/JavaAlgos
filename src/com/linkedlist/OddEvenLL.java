package com.linkedlist;

public class OddEvenLL {

    public static ListNode oddEvenList(ListNode head) {
        return head;
    }

    public static void main(String[] args) {
        ListNode nodes = new ListNode(1);
        for(int i=1;i<=5;i++){
            nodes.add(i+1);
        }
        System.out.println(oddEvenList(nodes));
    }
}
