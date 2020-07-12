package com.linkedlist;

import java.util.HashMap;

public class RandomPointer {
    static Node nodes[] = new Node[4];

    public static Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap();
        Node p = head;
        while(p != null){
            map.put(p,new Node(p.val));
            p = p.next;
        }
        p = head;
        while(p != null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        nodes[0] = new Node(1);
        for(int i=1;i<4;i++){
            nodes[i] = nodes[i-1].add(i+1);
        }
        nodes[0].random = nodes[2];
        nodes[1].random = nodes[3];
        nodes[2].random = nodes[0];
        nodes[3].random = nodes[0];

        Node newHead = copyRandomList(nodes[0]);
        System.out.println(newHead);
    }
}
