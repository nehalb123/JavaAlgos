package com.linkedlist;

import java.util.Stack;

public class AlternateEvenOdd {
    static ListNode nodes[] = new ListNode[7];

    static void alternateEvenOdd(ListNode head){
        //O(n) space
        Stack<ListNode> even = new Stack();
        Stack<ListNode> odd = new Stack();
        int i = 1;
        while(head!=null){
            //even data at odd position
            if(head.data%2==0 && i%2!=0){
                even.push(head);
            }else if(head.data%2!=0 && i%2==0){
                odd.push(head);
            }
            i++;
            head = head.next;
        }

        while(odd.size() > 0 && even.size() > 0){
            //swap the data
            int temp = odd.peek().data;
            odd.peek().data = even.peek().data;
            even.peek().data = temp;
            odd.pop();
            even.pop();
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,5,6,8};
        nodes[0] = new ListNode(arr[0]);
        for (int i =1;i<arr.length;i++){
            nodes[i] = nodes[i-1].add(arr[i]);
        }
        alternateEvenOdd(nodes[0]);
        System.out.println(nodes[0]);

    }
}
