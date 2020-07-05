package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SimplifyUnixDirectoryPath {

    static void simplifyPath(String path){
        Stack<String> st = new Stack<>();
        for(int i=0;i < path.length();) {
            int start = i;
            while (i+1 < path.length() && path.charAt(i + 1) != '/') {
                i++;
            }
            String dir = path.substring(start,++i).trim();
            //add directory to stack
            if(!dir.equals("/.") && !dir.equals("/") && !dir.equals("/..")){
                st.add(dir);
            }
            //ignore /. and pop for /..
            if(dir.equals("/..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        if(st.isEmpty()){
            st.add("/");
        }
        Stack<String> ans = new Stack<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        StringBuilder simplified = new StringBuilder();
        while(!ans.isEmpty()){
            simplified.append(ans.pop());
        }
        System.out.println(simplified);
    }

    public static void main(String[] args) {
        String path="/a//b////c/d//././/..";
        simplifyPath(path);
    }
}
