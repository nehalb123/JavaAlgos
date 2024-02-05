package com.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    static List<String> possibleStrings = new ArrayList();
    static Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public static void backtrack(int index, String digits, StringBuilder combination){
        if(digits.length() == combination.length()){
            possibleStrings.add(combination.toString());
            return;
        }

        String mapping = map.get(digits.charAt(index));
        for(char ch: mapping.toCharArray()){
            combination.append(ch);
            backtrack(index+1, digits, combination);
            combination.deleteCharAt(combination.length()-1);
        }
    }

    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return possibleStrings;
        }

        backtrack(0,  digits, new StringBuilder());
        return possibleStrings;
    }

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        System.out.println(result);
    }
}
