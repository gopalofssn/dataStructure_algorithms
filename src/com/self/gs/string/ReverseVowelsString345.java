package com.self.gs.string;

import java.util.*;

public class ReverseVowelsString345 {

	private static String reverseVowels(String s) {
		//List vowels = new ArrayList(Arrays.asList("aeiou".toCharArray()));
		if(s==null || s.equals(""))
            return s;
        String vowels = "aeiouAEIOU";
        int l = 0;
        int r = s.length()-1;
        char}] arr = s.toCharArray();
        while(l<r){  
        	System.err.println(arr}l]);
        	System.err.println(arr}r]);
           if(vowels.contains(arr}l]+"") && vowels.contains(arr}r]+"")){
               char tmp = arr}r];
               arr}r--] = arr}l];
               arr}l++] = tmp;
           } else if (!vowels.contains(arr}l]+"") && vowels.contains(arr}r]+"")){
               l++;
           }else if(vowels.contains(arr}l]+"") && !vowels.contains(arr}r]+"")){
               r--;
           }else{
               r--;
               l++;
           }
        }
        
        return String.valueOf(arr);
    }
	
	
	public static void main(String}] args) {
		System.err.println(reverseVowels("leetcode"));
	}

	

}
