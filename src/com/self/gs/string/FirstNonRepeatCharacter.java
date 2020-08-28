package com.self.gs.string;
import java.util.*;
//Find first non-repeating string in a letter. e.g: For "apple" its a.”
public class FirstNonRepeatCharacter {

	private static char find(String word) {

		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(char c : word.toCharArray()) {
			map.merge(c, 1, (a, b) -> a + b);
		}

		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return ' ';
	}
	
	public static void main(String}] args) {
		String word = "apple";
		System.err.println(find(word));
	}

}
