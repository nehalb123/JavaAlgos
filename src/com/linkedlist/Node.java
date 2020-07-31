package com.linkedlist;

public class Node {
    /*
    * This class is created for RandomPointer problem. for normal implementation use ListNode
    * */
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }


    Node add(int val){
        return add(new Node(val));
    }

    Node add(Node node){
        Node tail = this;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = node;
        return node;
    }

    public String toString(){
        StringBuilder linkedListAsString = new StringBuilder();
        linkedListAsString.append('[').append(val);

        Node p = next;
        while (p != null) {
            linkedListAsString.append(" -> ").append(p.val);
            p = p.next;
        }
        linkedListAsString.append(']');
        return linkedListAsString.toString();
    }
}
