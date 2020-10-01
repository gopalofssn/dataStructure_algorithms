package com.self.gs.string;

import java.util.*;
/*
 Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  pattern = }'x','y','z'], str = "xyyzyznyx"

output: "znyx"
 */
public class ShortestUniqueSubstring {
	
/*
 xyaoyz - has x y z
 zyx   - has x y z
 
 so shortestUniqueSubstring is zyx
 
 approach 
   Store pattern char and it's total count in hashmap 
   perform sliding window on string and keep gathering char and increment counts
   compare two hashmap
   
 */
   private static String getShortestUniqueSubstring(char[] p, String s) {
	   if(p == null || p.length==0 || s==null )
	        return null;
	     Map<Character,Integer> pMap = new HashMap<Character,Integer>();
	     Map<Character,Integer> sMap = new HashMap<Character,Integer>();
	     for(char c:p){
	       addToMap(c,pMap);
	     }
	     int l=0,r=0;
	     String result=s+s;
	     while(r<s.length()){
	       Character c = s.charAt(r);
	       System.err.println(c);
	       if(pMap.containsKey(c)){
	         addToMap(c,sMap);
	       }
	       while(isMatch(pMap,sMap)){
	         String tmp = s.substring(l,r+1);  
	         if(tmp.length()<result.length())
	           result = tmp;
	         removeFromMap(s.charAt(l++),sMap);
	       }  
	       r++;
	     }
	    
	    return (result.equals(s+s)?"":result);
	  }

	  private static boolean isMatch(Map<Character,Integer> pMap, Map<Character,Integer> sMap){
	    if(pMap.size()!=sMap.size())
	      return false;
	    for(char c:pMap.keySet()){
	      if(!sMap.containsKey(c) || sMap.get(c) < pMap.get(c))
	        return false;
	    }
	    return true;
	  }
	  private static void addToMap(char c, Map<Character,Integer> map){
	    map.merge(c,1,(a,b)->a+b);
	  }
	  private static void removeFromMap(char c, Map<Character,Integer> map){
	    if(map.containsKey(c)){
	      int count= Math.max(map.get(c)-1,0);
	      map.put(c,count);
	    }
	  }
    
	public static void main(String[] args) {
		   System.err.println("Result : " + getShortestUniqueSubstring( new char[]{'x','y','z'},"xyaoyzyziyxz"));
		   System.err.println("Result : " + getShortestUniqueSubstring( new char[]{'x','y','z','y'},"xyaoyzyzy"));
	}

   
}
