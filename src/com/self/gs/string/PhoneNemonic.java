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

    public static void DFS(String digits, List<String> result, StringBuilder s, int start) {
    	if (start == digits.length()) {
    		result.add(s.toString());
    	}
    	else {
    		String tmp = map.get(digits.charAt(start));
    		System.err.println("tmp - " + tmp);
    		for (int i = 0; i < tmp.length(); i++) {
    			System.err.println("adding char ..." + tmp.charAt(i));
    			s.append(tmp.charAt(i));
    			DFS(digits, result, s, start + 1);
    			s.deleteCharAt(s.length() - 1);
    		}
    	}
    }

    public static List<String> letterCombinations(String digits) {
    	if (digits == null || digits.length() == 0)
    		return new ArrayList<String>();
    
    	List<String> result = new ArrayList<String>();
    	StringBuilder s = new StringBuilder();
    	DFS(digits, result, s, 0);
    	return result;
    }
    
    public static void main(String[] args) {
		System.err.println(letterCombinations("23"));
	}
}
