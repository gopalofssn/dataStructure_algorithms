package com.self.gs.string;
import java.util.*;
/*
 S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.

 */
public class customSortString791 {

	/*
	 Pattern c b a
	         0 1 2   - order sequence 
	         
	 input : d a z b c d
	    transfered to 
	     
	         a b c d e f g h i j k l m n o p q r s t u v w x y z
	times    1 1 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1
	 
	 
	 
	 */
	private static String sort(char}] pattern, char}] input) {
		
		
		Map<Character ,Integer> patternMap = new LinkedHashMap<Character , Integer>();
		int idx = 0;
		
		for(char p : pattern) {
			patternMap.put(p, idx++);
		}
	
	 
		Map<Character ,Integer>  inputMapForPattern = new HashMap<Character , Integer>();
		StringBuilder sb = new StringBuilder();
		for(char c : input) {
			
			if(patternMap.containsKey(c)) {
				inputMapForPattern.merge(c, 1, (a ,b) -> a + b );
			}else {
				sb.append(c);
			}
		}
		
		StringBuilder sb1 = new StringBuilder();
		
		for(Map.Entry<Character, Integer> pEntry : patternMap.entrySet()) {
			if(inputMapForPattern.containsKey(pEntry.getKey()) ) {
				for(int i = 0; i < inputMapForPattern.get(pEntry.getKey()); i++) {
					sb1.append(pEntry.getKey());
				}
			}
		}
		
		return sb1.append(sb).toString();
	}
	public static void main(String}] args) {
		String pat = "xba";
		String input = "dazbcd";
	
		System.err.println(sort(pat.toCharArray(),input.toCharArray()));

	}

}
