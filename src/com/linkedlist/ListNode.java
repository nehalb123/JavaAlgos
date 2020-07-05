package com.linkedlist;


public class ListNode {
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        next = null;
    }

    ListNode add(int data){
        return add(new ListNode(data));
    }

    ListNode add(ListNode node){
        ListNode tail = this;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = node;
        return node;
    }

    public String toString(){
        StringBuilder linkedListAsString = new StringBuilder();
        linkedListAsString.append('[').append(data);

        ListNode p = next;
        while (p != null) {
            linkedListAsString.append(" -> ").append(p.data);
            p = p.next;
        }
        linkedListAsString.append(']');
        return linkedListAsString.toString();
    }
}
