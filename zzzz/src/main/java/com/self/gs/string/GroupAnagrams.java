package com.self.gs.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	/*
	  Map<String , List<String>> holder 
	    
	       char[26] - fill value
	       e a t    
	       1 1 1  => 
	       a1e1t1 - key 
	       
	       t e a
	       1 1 1 
	       a1e1t1 - key 
	       
	       add value (word) by key in the map
	       
	 */
	private static String[][] groupAnagrams(String[] strs) {
		Map<String, List<String>> anagramsHolder = new HashMap<String, List<String>>();
		for(String s : strs) {
			int[] keyArray = buildKeyArray(s);
			String key = buildKey(keyArray);
			anagramsHolder.putIfAbsent(key, new ArrayList<String>());
			anagramsHolder.get(key).add(s);
		}
		return convertAndSend(anagramsHolder.values());
	}
	
	private static String buildKey(int[] keyArray) {
		StringBuilder sb = new StringBuilder();
		for(char c = 'a' ; c <= 'z'; c++) {
			int val = keyArray[c - 'a'];
			if(val != 0) {
				sb.append(c)
				  .append(val);
			}
		}
		return sb.toString();
	}

	private static int[] buildKeyArray(String s) {
		int[] nums = new int[26];
		for(char c : s.toCharArray()) {
			nums[c - 'a']++;
		}
		return nums;
	}

	private static String[][] convertAndSend(Collection<List<String>> anagramsGroup) {
		String[][] result = new String[anagramsGroup.size()][];
		int count = 0;
		for(List<String> group : anagramsGroup) {
			result[count++] = convertAndAssign(group);
		}
		return result;
	}

	private static String[] convertAndAssign(List<String> strs) {
		String[] result = new String[strs.size()];
		int count = 0;
		for(String s : strs) {
			result[count++] = s;
		}
		return result;
	}

	public static void main(String[] args) {

		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		String[][] group = groupAnagrams(strs);
		for(String[] g : group) {
			System.out.println(Arrays.toString(g));
		}
	}
	
}
