package com.gs.alien.dictionary;

import java.util.*;

public class AllienDictionary {
	
	private static boolean isAlienSorted(String[] words, String order) {
		Map<Character, Integer> charPositionMap = buildCharPositionMap(order);
		System.out.println(" Char Order by Poistion  Map - " + charPositionMap);
		for(int i = 1; i < words.length; i++){
			String prevWord = words[i -1];
			String currentWord = words[i];
			if(!compareWordsByAlienOrder(prevWord, currentWord, charPositionMap))
				return false;
		}
		return true;
	}
	
	/*
	 "hello"
	 "leetcode"
	 true - if it is order
	 false - if it is not order
	 */
	private static boolean compareWordsByAlienOrder(String prevWord, String currentWord,
			Map<Character, Integer> charPositionMap) {
		if(isNullOrEmpty(prevWord) || isNullOrEmpty(currentWord) ) return false;
		int prevWordLen = prevWord.length();
		int currentWordLen = currentWord.length();
		int min = Math.min(prevWordLen, currentWordLen);
		char[] v1 = prevWord.toCharArray();
		char[] v2 = currentWord.toCharArray();
		for(int i = 0; i < min; i++){
			char c1 = v1[i];
			char c2 = v2[i];
			if(c1 != c2){
				return charPositionMap.get(c1) < charPositionMap.get(c2);
			}
		}
		return prevWordLen < currentWordLen;
	}

	private static boolean isNullOrEmpty(String word) {
		return (word == null || word.trim().isEmpty());
	}

	private static Map<Character, Integer> buildCharPositionMap(String order) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int index = 0;
		for(char c : order.toCharArray()){
			map.put(c, index++);
		}
		return map;
	}

	public static void main(String[] args) {
		String[] words = {"leetcode", "hello",};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(isAlienSorted(words, order));
		
		String[] words2 = {"app","apple"};
		System.out.println(isAlienSorted(words2, order));
	}


}