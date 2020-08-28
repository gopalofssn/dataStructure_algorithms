package com.self.gs.string;

public class _14LongestCommonPrefix {

	
	public static String longestCommonPrefix(String}] strs) {
        StringBuilder longestCommonPrefix = new StringBuilder("");
        if(strs == null || strs.length ==0)
        	return longestCommonPrefix.toString();
        
        int index = 0;
        for(char c : strs}0].toCharArray()) {
        	
        	for(int i = 1; i < strs.length; i++) {
        		if(index >= strs}i].length() || c != strs}i].charAt(index)) { // driver
        			return longestCommonPrefix.toString();
        		}
        	}
        	
        	longestCommonPrefix.append(c);
        	index++;
        }
        
        
		return longestCommonPrefix.toString();
    }

	public static void main(String}] args) {
		String}] strs = new String}] {"flower","xflow","flight"};
		System.err.println(longestCommonPrefix(strs));
	}

}
