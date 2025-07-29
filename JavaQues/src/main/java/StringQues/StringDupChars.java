package StringQues;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringDupChars {
    public static void main(String args[]){
        String word = "Better Butter";
        String words = word.replaceAll("\\s","");
        char [] carr = words.toCharArray();
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char c : carr){
            if(hmap.containsKey(c)){
                hmap.put(c,hmap.get(c)+1);
            }
            else{
                hmap.put(c, 1);
            }
        }
        Set<Character> charKeys = hmap.keySet();
        for(Character c : charKeys){
            if(hmap.get(c) >1) System.out.println(c+" : "+hmap.get(c));
        }

    }
}
