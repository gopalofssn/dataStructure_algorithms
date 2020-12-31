package com.gs.alien.dictionary;

import java.util.*;

public class AllienDictionary {

	public boolean isAlienSorted(String[] words, String order) {
		if(isNullOrEmpty(order) || words == null || words.length <= 1) {
			return true;
		}
		
		Map<Character, Integer> orderMap = new HashMap<>();
		int index = 0;
		for(char c : order.toCharArray()) {
			orderMap.put(c, index++);
		}
		
		return isAlienSorted(words, orderMap);
	}

	private  boolean isAlienSorted(String[] words, Map<Character, Integer> orderMap) {
		
		for(int index = 1; index < words.length; index++) {
			boolean isSorted = isSorted(words[index - 1], words[index], orderMap);
			if(!isSorted)  return false;
		}
		
		return true;
	}
	
	private boolean isSorted(String prev, String current, Map<Character, Integer> orderMap) {
		if(isNullOrEmpty(prev) && !isNullOrEmpty(current)) {
			return true;
		}else if(!isNullOrEmpty(prev) && isNullOrEmpty(current)) {
			return false;
		}
		
		int prevLength = prev.length();
		int currentLength = current.length();
		int len = (prevLength < currentLength) ? prevLength : currentLength;
		
		for(int i = 0 ; i < len; i++) {
			char pChar = prev.charAt(i);
			char cChar = current.charAt(i);
			if(pChar == cChar)  continue;
			else return orderMap.get(pChar) < orderMap.get(cChar);
		}
		
		return prevLength < currentLength;
	}
	
	private boolean isNullOrEmpty(String s) {
		return s == null || s.trim().isEmpty();
	}

	public static void main(String[] args) {
		AllienDictionary allienDictionary = new AllienDictionary();
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		String[] words = { null, "hello", "leetcode" }; // true
		System.out.println(allienDictionary.isAlienSorted(words, order));
		String[] words2 = { "apple", "app" }; // false
		System.out.println(allienDictionary.isAlienSorted(words2, order));
		String[] words3 = { "app", "", "apple" }; // false , "" is in middle
		System.out.println(allienDictionary.isAlienSorted(words3, order));
	}

}
