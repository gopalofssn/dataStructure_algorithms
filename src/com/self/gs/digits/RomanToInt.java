package com.self.gs.digits;

import java.util.*;

public class RomanToInt {
    static Map<Character,Integer> digitMapper = new HashMap<Character,Integer>(){{
    	put('I',1);
    	put('V',5);
    	put('X',10);
    	put('L',50);
    	put('C',100);
    	put('D',500);
    	put('M',1000);
    }};
    
	private static int convert(String s) {
		 int result = 0;
		 
		 int idx = 0;
		 
		 while(idx < s.length()) {
			 if((idx+1) < s.length() && ( digitMapper.get(s.charAt(idx)) < digitMapper.get(s.charAt(idx + 1)) ) ) {
				 result +=  digitMapper.get(s.charAt(idx + 1)) -  digitMapper.get(s.charAt(idx));
				 idx += 2;
			 }else {
				 result +=  digitMapper.get(s.charAt(idx));
				 idx++;
			 }
			 
		 }
		 
		
		return result;
	}
	
	public static void main(String[] args) {
	 System.err.println(convert("LVIII"));  // L + V + I + I + I
	 System.err.println(convert("MCMXCIV")); // M + (M-C) + (C-X) + (V-I)
	}
}
