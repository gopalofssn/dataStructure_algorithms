package com.self.gs.stackqueue;

import java.util.*;

public class _767ReOrganizeString {

  public static String reorganizeString(String S) {
        if(S == null || S.length() == 0) {
        	return "";
        }
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        
        for(char c : S.toCharArray()) {
        	int i = counts.merge(c, 1, (a,b) -> a + b);
        	System.err.println(i + "," + c);
        	if(counts.get(c) > ( (S.length() + 1) /2) )
        		return "-1";
        }
       // System.err.println(counts);
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<Character>( (a, b) -> counts.get(b) - counts.get(a) );
        maxHeap.addAll(counts.keySet());
        
        StringBuilder sb = new StringBuilder();
        while(maxHeap.size() > 1) {
        	char first = maxHeap.poll();
        	char second = maxHeap.remove();
        	sb.append(first);
        	sb.append(second);
        	
        	if( counts.merge(first, 1, (a,b) -> a - b) > 0) {
        		maxHeap.add(first);
        	}
        	
        	if( counts.merge(second, 1, (a,b) -> a - b) > 0) {
        		maxHeap.add(second);
        	}
        	
        	//System.err.println(counts);
        	
        }
        
        if(maxHeap.size() == 1) {
        	char c = maxHeap.poll();
        	sb.append(c);
        	
        	if( counts.merge(c, 1, (a,b) -> a - b) > 0) {
        		return "-2";
        	}
        	
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		System.err.println(reorganizeString("aabs"));
		System.err.println(reorganizeString("aaab"));
		//System.err.println(reorganizeString("aaabsbsaaa"));

	}

}
