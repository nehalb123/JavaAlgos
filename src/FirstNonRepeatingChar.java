import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingChar {

    char firstNonRepeatingCharAnother(String s){
        //solution 2
        int alphabets[] = new int[26];

        for(char c: s.toCharArray()){
            alphabets[c-'a']++;
        }
        for(char c: s.toCharArray()){
            if(alphabets[c-'a'] == 1){
                return c;
            }
        }
        return '_';
    }

    char firstNonRepeatingChar(String s){
        //solution 1
        HashMap<Character, Integer> char_counts = new HashMap<>();
        for(int i=0; i< s.length();i++){
            char c = s.charAt(i);
            if(char_counts.containsKey(c)){
                char_counts.put(c,char_counts.get(c)+1);
            } else{
                char_counts.put(c,1);
            }
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(char_counts.get(c) == 1) return c;
        }
        return '_';
    }

    public static void main(String[] args) {
        FirstNonRepeatingChar fnrc = new FirstNonRepeatingChar();
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter testcase no.:");
        int testcase = sc.nextInt();
        switch(testcase){
            case 1:
                s = "aaabcdcee";
                break;
            case 2:
                s = "abcbad";
                break;
            default:
                s = "abcabcabc";
        }
        char ch = fnrc.firstNonRepeatingChar(s);
        char ch2 = fnrc.firstNonRepeatingCharAnother(s);
        System.out.println(ch);
        System.out.println(ch2);
    }
}
