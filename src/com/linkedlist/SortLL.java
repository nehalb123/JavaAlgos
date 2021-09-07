package com.linkedlist;

/**
 *
 */
public class SortLL {

    static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left, right);
    }


    static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    static ListNode getMid(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            if(fast != null){
                slow = slow.next;
            }

        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }


    public static ListNode sortList(ListNode head) {
        return  mergeSort(head);
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 1, 3};
        ListNode nodes = new ListNode(arr[0]);
        for(int i=1; i < arr.length; i++){
            nodes.add(arr[i]);
        }
        ListNode sortedHead = sortList(nodes);
        System.out.println(sortedHead);
    }


}
