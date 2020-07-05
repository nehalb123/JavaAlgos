package com.linkedlist;


public class ReverseAlternateK {
    static ListNode nodes[] = new ListNode[15];

    static ListNode reverseAlternateKNodes(ListNode node, int k){
        ListNode curr = node;
        ListNode next = null , prev = null;
        int count = 0;

        /*Reverse first k nodes*/
        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        /*Attach the k nodes list to remaining list*/
        if(node!=null){
            node.next = curr;
        }
        /*Skip k nodes i.e. k-1 links*/
        count = 0;
        while(count<k-1 && curr != null){
            curr = curr.next;
            count++;
        }
        /*Recursively call this func till curr = null*/
        if(curr!=null){
            curr.next = reverseAlternateKNodes(curr.next,k);
        }
        /*Return new head*/
        return prev;
    }

    public static void main(String[] args) {
        nodes[0] = new ListNode(1);
        for(int i=1;i<15;i++){
            nodes[i] = nodes[i-1].add(i+1);
        }
        int k = 3;
        ListNode head = reverseAlternateKNodes(nodes[0],k);
        System.out.println(head);
    }
}
