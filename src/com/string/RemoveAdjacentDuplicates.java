package com.string;


import java.util.Stack;

/**
 * 1209. Remove All Adjacent Duplicates in String II
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters
 * from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 *
 * Rating: ⭐ ⭐ ⭐ ⭐, this problems uses stack instead of two pointers which simplifies string manipulation.
 */
public class RemoveAdjacentDuplicates {

    static class Node{
        char ch;
        int count;
        Node(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    static String removeAdjacentDuplicates(String s, int k){
        Stack<Node> stack = new Stack<>();
        for(int i=0; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek().ch == s.charAt(i)){
                stack.peek().count++;
            } else{
                stack.push(new Node(s.charAt(i), 1));
            }

            if(stack.peek().count == k){
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Node n : stack){
            for(int i=0; i < n.count; i++){
                sb.append(n.ch);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        String result = removeAdjacentDuplicates(s, k);
        System.out.println(result);
    }
}
