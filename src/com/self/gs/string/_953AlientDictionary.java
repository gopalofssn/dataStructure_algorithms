package com.self.gs.string;

import java.util.*;

public class _953AlientDictionary {
	 public static boolean isAlienSorted(String[] words, String order) {
	     
			 Map<Character ,Integer> orderMap = new HashMap<Character ,Integer>();
			 int index = 0;
			 for(char c : order.toCharArray()) {
				 orderMap.put(c, index++);
			 }
			  
			 for(int i = 0; i < words.length - 1; i++) {
				 if(isBigger(words[i] ,words[i+1] ,orderMap)) {
					 return false;
				 }
			 }
			 
			 return true;
		    }
		 
		private static boolean isBigger(String s1, String s2, Map<Character, Integer> orderMap) {
			 int len1 =  s1.length();
			 int len2 =  s2.length();
			 
			 int limit = Math.min(len1, len2);
			 int idx = 0;
			 
			 while(idx < limit) {
				 char c1 = s1.charAt(idx);
				 char c2 = s2.charAt(idx);
				 if(c1 != c2) {
					 return orderMap.get(c1) > orderMap.get(c2);
				 }
				 idx++;
			 }
				 
			return len1 > len2;
			
		}
	public static void main(String[] args) {
		String[] words = {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.err.println(isAlienSorted(words, order));
		
		String[] words2 = {"app","apple"};
		System.err.println(isAlienSorted(words2, order));
		
		int m = words2[0].length();
		int n = words2[1].length();
		for(int i = 0; i < m && i < n; i++) {
			System.err.println(words2[0].charAt(i) + "," + words2[1].charAt(i) );
			if(words2[0].charAt(i) != words2[1].charAt(i)) {
				
			}
		}
		
		

	}

}
