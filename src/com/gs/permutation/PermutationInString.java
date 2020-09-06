package com.gs.permutation;

import java.util.*;

/*
 Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
 */
public class PermutationInString {

	public boolean checkInclusion(String s1, String s2) {
        if(isNullOrEmpty(s1) || isNullOrEmpty(s2)) return false;
        final int S1LEN = s1.length();
        final int S2LEN = s2.length();
        Map<Character, Integer> s1Map = Collections.unmodifiableMap(constructMap(s1));
        Map<Character, Integer> s2Map = constructMap(s2.substring(0, S1LEN));
        if(isSame(s1Map, s2Map)){
            return true;
        }
        int l = 0;
        int r = S1LEN;
        while(r < S2LEN) {
            char rightChar = s2.charAt(r++);
            addToMap(s2Map, rightChar);
            char leftChar = s2.charAt(l++);
            removeFromMap(s2Map, leftChar);
            if(isSame(s1Map, s2Map)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isNullOrEmpty(String s){
        return (s == null || s.isEmpty());
    }
    
    private Map<Character, Integer> constructMap(String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
           addToMap(map, c);
        }
        return map;
    }
    
    private void addToMap(Map<Character, Integer>  map, char c){
         map.merge(c, 1, (a,b) -> a + b);
    }
    
    private void removeFromMap(Map<Character, Integer>  map, char c){
         map.computeIfPresent(c, (key, val) -> (val -1) );
         if(map.containsKey(c) && map.get(c) == 0){
             map.remove(c);
         }
        
    }
    
    private boolean isSame(Map<Character, Integer>  p, Map<Character, Integer>  q){
    	
        if(p.size() != q.size()) return false;
        for(Map.Entry<Character, Integer> entry : p.entrySet()){
            char key = entry.getKey();
            int count = entry.getValue();
            if(!q.containsKey(key) || q.get(key) != count) return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		System.err.println(new PermutationInString().checkInclusion("adc", "dcda"));

	}

}
