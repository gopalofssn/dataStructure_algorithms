package com.self.gs.string;

import java.util.*;
import java.util.Map.Entry;
/*
 Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  arr = ['x','y','z'], str = "xyyzyznyx"

output: "znyx"
 */
public class ShortestUniqueSubstring {
	

   private static String getShortestUniqueSubstring(char[] patternArray, String input) {
	   if(patternArray==null || input==null)
		   throw new IllegalArgumentException("Either pattern or search string is/are null !!!");
	   Map<Character,Integer> pattern = new HashMap<Character,Integer>();
	   for(char ch:patternArray) {
		   addToMap(pattern, ch);
	   }

	   Map<Character,Integer> holder = new HashMap<Character,Integer>();
	   String result=input+input;
	   int l=0,r=0;
	   while(r<input.length()){
		   addToMap(holder, input.charAt(r));
		   
		   if(isMatch(pattern,holder)) {
			 result = calculateMinString(input, result, l, r);
			   while(l<r) {
				   removeMapValueByOneIfPresent(holder,input.charAt(l));
				   l++;
				   if(isMatch(pattern,holder)) {
					   result = calculateMinString(input, result, l, r);
				   }else {
					   break;
				   } 
			   }
		   }
		   r++;
	   }
	   return (result.equals(input+input))?"":result;
	 }

	private static String calculateMinString(String input, String result, int l, int r) {
		String tmp = input.substring(l,r+1); 
		   if(tmp.length()<result.length()) {
			   result = tmp;
		       System.err.println("possible result  - " + result );
		   }
		return result;
	}

	private static void removeMapValueByOneIfPresent(Map<Character, Integer> map, char ch) {
		if(map.containsKey(ch)) 
	       map.put(ch,map.get(ch)-1);
    }

	private static boolean isMatch(Map<Character, Integer> pattern, Map<Character, Integer> holder) {
	 for(Entry<Character, Integer> p:pattern.entrySet()) {
		   Character pKey = p.getKey();
		   Integer pValue = p.getValue();
		   if(!holder.containsKey(pKey) || holder.get(pKey) < pValue)
			   return false;
	 }
	 return true;
    }

	private static void addToMap(Map<Character, Integer> map, char ch) {
		map.merge(ch, 1, (a,b)->(a+b));
	}
   
	
	  
	   public static void main(String[] args) {
		   System.err.println("Result : " + getShortestUniqueSubstring( new char[]{'x','y','z'},"xyaoyzyzyx"));
	}

   
}
