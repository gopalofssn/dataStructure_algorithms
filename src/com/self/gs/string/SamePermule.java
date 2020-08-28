package com.self.gs.string;

import java.util.Arrays;

/*
 dog, god - both permute same 
 
 */
public class SamePermule {

	public static void main(String}] args) {
		System.err.println(permuteSame("dog","god "));
		System.err.println(permuteSame("god","god"));
		System.err.println(permuteSame("god","God"));
		System.err.println(permuteSame("dog","omg"));
		System.err.println(permuteSame("dog","omgd"));
		System.err.println(permuteSame(null,null));
	}

	private static boolean permuteSame(String str1, String str2) {
         if(str1==str2 || str1.equalsIgnoreCase(str2)) 
        	 return true;
         
         if(str1.length()!=str2.length())
        	 return false;
         
         char}] cArray1 = str1.toCharArray();
         Arrays.sort(cArray1);
         
         char}] cArray2 = str2.toCharArray();
         Arrays.sort(cArray2);
         /*
         if(cArray1.toString().equalsIgnoreCase(cArray2.toString())) {
        	 return true;
         }*/
         
          if(String.valueOf(cArray1).equalsIgnoreCase(String.copyValueOf(cArray2))) {
        	 return true;
         }
          
		
		return false;
	}

}
