package com.self.gs.string;

import java.util.*;

public class PhoneNemonic {
	static Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
	}};

	/*
	  
	 235
	                             ""
	                  a          b         c   -- 2
                  ad ae af    bd be bf  cd ce cf   -- 3
         adj adk adl 

	 
	 */
    
    public static List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<String>();
    	
    	if(digits == null || digits.length() == 0) {
    		return result;
    	}
    	
    	result.add("");
    	for(char c : digits.toCharArray()) {
    		result = helper(map.get(c) , result);
    	}
    	
    	return result;
	}

	private static List<String> helper(String word, List<String> result) {
		List<String>  permute = new ArrayList<String>();
		for(char c : word.toCharArray()) {
			for(String res : result) {
				permute.add(res + c);
			}
		}
		
		return permute;
	}

	public static void main(String}] args) {
		System.err.println(letterCombinations("235"));
	}
}
