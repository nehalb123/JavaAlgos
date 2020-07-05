package com.interview;

import java.util.ArrayList;
import java.util.List;

public class ExtractHierarchicalData {

    static List<String> extractData(String input, int level){
        List<String> data = new ArrayList<>();
        int countLevel = 0;
        int startPrint;
        for(int i = 0; i < input.length();){
            if(input.charAt(i) == '{'){
                countLevel++;
            }else if(input.charAt(i) == '}'){
                countLevel--;
            }
            i++;
            if(countLevel == level){
                startPrint = i;
                while(input.charAt(i) != '{' && input.charAt(i) != '}'){
                    i++;
                }
                String trimmed = input.substring(startPrint,i).trim();
                if(trimmed.length() > 0) {  //to avoid empty string being added in the list
                    data.add(trimmed);
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        String input = "{Money Heist Info {The most imp char is professor}{Another " +
                "character is Berlin {Berlin is in charge of the heist}}{Another character is Moscow{Moscow is Denver's dad}}}";
        int level = 2;
        List<String> data = extractData(input,level);
        System.out.println(data);
    }
}
