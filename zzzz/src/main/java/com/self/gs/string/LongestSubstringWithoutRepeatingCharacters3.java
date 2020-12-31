package com.self.gs.string;
import java.util.*;
/*
 Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
   /*
    sliding window
    a b c a b c b b
    L   R            - abc , 3 char
    L     R          -  seen a already , move L
      L   R          - bca , still 3 char 
      L     R        -- seen b already , move L
        L   R		 - cab , still 3 char
        L     R      - seen c already , move L
          L   R      - abc , still 3 char
          L     R     - seen b, move L
            L   R     - still move L
              L R     - 2 chara
              L   R   - seen b already ,
    */
	private static int solution(String s) {

		 if(s == null || s.length() == 0) {
			 return 0;
		 }
		 
		 int l = 0;
		 int r = 0;
		 int max = 0;
		 Set<Character> uniqueSet = new HashSet<Character>();
		 
		 while(r < s.length()) {
			 char c = s.charAt(r);
			 if(uniqueSet.add(c)) {
				 r++;
				 max = Math.max(max, uniqueSet.size());
			 }else {
				 uniqueSet.remove(s.charAt(l));
				 l++;
			 }
		 }
		 
		 
		 return max;
		
	}
	
	public static void main(String}] args) {
		System.err.println(solution("abacaecbb")); //pwwkew  abcabcbb

	}


}
