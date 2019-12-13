package com.self.gs.string;

public class LongestPalindromicSubsequence516 {
	
	/*
	 aba , ans =3
	 
	 */
	private static int recurssive(String str, int start, int len) {
		 if(len==0)
			 return 0;
		 if(len==1)
			 return 1;
		 if(str.charAt(start)==str.charAt(start+len-1)) // why start+len-1
			 return 2 + recurssive(str,start+1,len-2); // why len-2?
		 else
			 return Math.max(recurssive(str,start+1,len-1),recurssive(str,start,len-1) );
	}
	

	public static void main(String[] args) {
		 String str = "agbdba";
		 System.err.println("LPS using recurssive - " + recurssive(str,0,str.length()));

	}

}
