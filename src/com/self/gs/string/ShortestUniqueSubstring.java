package com.self.gs.string;

import java.util.*;
/*
 Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"
 */
public class ShortestUniqueSubstring {
	
  
   public static void main(String[] args) {
	   System.out.println(getShortestUniqueSubstring(new char[]{'x','y','z'},"xyyzyzyx"));
}

   private static String getShortestUniqueSubstring(char[] arr, String str) {
	  Set<Character> arrChar = new HashSet<Character>();
	  for(char c:arr) {
		  arrChar.add(c);
	  }
	  Set<Character> shortUniqueSubStr = new LinkedHashSet<Character>();
	  for(char c:str.toCharArray()) {
		  if(!arrChar.contains(c))
			  continue;
		  if(shortUniqueSubStr.contains(c)) {
			  shortUniqueSubStr.
		  }
		  shortUniqueSubStr.add(c);
		  if(shortUniqueSubStr.size()==arrChar.size()) {
			  return shortUniqueSubStr.toString();
		  }
		  
	  }
	  return "none";
  }
}
