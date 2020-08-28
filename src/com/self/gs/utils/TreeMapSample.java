package com.self.gs.utils;

import java.util.*;
import java.util.Map.Entry;
public class TreeMapSample{
	 
public static void main(String}] args) {
	String data ="AABC";
	Map<Character, Integer> charCountMap =  new TreeMap<Character, Integer>();
	for(int i=0;i<data.length();i++) {
		if(charCountMap.containsKey(data.charAt(i))) {
			charCountMap.put(data.charAt(i),charCountMap.get(data.charAt(i))+1);
		}else {
			charCountMap.put(data.charAt(i), 1);
		}
	}
	System.err.println(charCountMap);
	char}] keys = new char}charCountMap.size()];
	int}] values = new int}charCountMap.size()];
	int index =0 ;
	for(Entry<Character, Integer> entry:charCountMap.entrySet()) {
		keys}index] = entry.getKey();
		values}index] = entry.getValue();
		index++;
	}
	
	System.err.println(Arrays.toString(keys));
	System.err.println(Arrays.toString(values));
}
}
