package com.trie;


import java.util.ArrayList;
import java.util.List;

/**
   Diagram: https://imgur.com/EvU8Gcy
 */
public class Trie {

    TrieNode root;
    Trie(){
        this.root = new TrieNode();
    }

    static class TrieNode{
        int terminating;  //count
        TrieNode[] trieNodes = new TrieNode[26];

        private TrieNode next(char ch){
            return trieNodes[ch-'a'];
        }
    }

    public int query(String s){
        TrieNode current = root.next(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(current == null){
                return 0;
            }
            current = current.next(s.charAt(i));
        }
        return current.terminating;
    }

    public void insert(String s){
        TrieNode current = root;
        for(int i=0;i<s.length();i++){
            if(current.next(s.charAt(i)) == null){
                //create the node
                current.trieNodes[s.charAt(i)-'a'] = new TrieNode();
            }
            current = current.next(s.charAt(i));
        }
        current.terminating++;
    }

    public void delete(String s){
        TrieNode current = root.next(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(current == null){
               throw new RuntimeException("String does not exists");
            }
            current = current.next(s.charAt(i));
        }
        if(current.terminating!=0) {
            current.terminating--;
        }else{
            throw new RuntimeException("Deleting a string that does not exist");
        }
    }

    public void update(String old, String toUpdate){
        delete(old);
        insert(toUpdate);
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("pqrs");
        stringList.add("psst");
        stringList.add("pprt");
        stringList.add("qqrs");
        stringList.add("pqrs");
        Trie trie = new Trie();
        stringList.forEach(trie::insert);

        System.out.println(trie.query("qqrs"));
        System.out.println(trie.query("psst"));
        trie.update("qqrs","psst");
        System.out.println(trie.query("qqrs"));
        System.out.println(trie.query("psst"));
    }
}
