package com.self.gs.string;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

	/*
	 AABABBA
	 0123456
	 A -> 0 1 3 6
	 B -> 2 4 5
	 
	 k = 1
	     0 1 3 6
	     A AAA
	     
	     
	   ABAB
	   
	 */
	public int characterReplacement(String s, final int k) {
        if(isNullOrEmpty(s)) return 0;
        Map<Character, LinkedList<Integer>> distanceByChar = new HashMap<Character, LinkedList<Integer>>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            distanceByChar.putIfAbsent(c, new LinkedList<Integer>());
            distanceByChar.get(c).addLast(i);
        }
        System.err.println(distanceByChar);
        if(distanceByChar.size() == 1) return s.length();
        
        int max = 0;
        for(Map.Entry<Character, LinkedList<Integer>> entry : distanceByChar.entrySet()){
            char key = entry.getKey();
            System.err.println("key " + key);
            int ktmp = k;
            int tmpMax = 1;
            LinkedList<Integer> vals = entry.getValue();
            for(int i = 1; i < vals.size(); i++){
                int distance = vals.get(i) - vals.get(i - 1) - 1;
                System.err.println("dist " + distance);
                if( distance <= ktmp ){
                  tmpMax += distance + 1;
                  ktmp -= distance;
                }
            }
            tmpMax += ktmp;
            max = Math.max(max, tmpMax );
        }
        return max;
    }
    private boolean isNullOrEmpty(String s){
        return (s == null || s.isEmpty());
    }
	public static void main(String[] args) {
		System.err.println(new LongestRepeatingCharacterReplacement().characterReplacement("AAAB", 0));
		/*
		System.err.println(new LongestRepeatingCharacterReplacement().characterReplacement("AAAA", 0));
		System.err.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
		System.err.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));*/

	}

}
