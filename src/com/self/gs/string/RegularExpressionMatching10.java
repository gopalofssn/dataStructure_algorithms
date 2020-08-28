package com.self.gs.string;

import java.util.HashSet;

public class RegularExpressionMatching10 {

	/* Dynamic Programming
	 
	    * - go back and put col}curent - 2]  , "" = a* , b=a*
	    . - diagonal value  ,, ie, ab = a. ,  ax = a.
	    
	    X a * b . c
	 X  T F T F F F
	 a  F T F F F F         // (a,*) false , because }col-2] = false  , (a,.) diagonal value (ok with what decided in previous)
	 a  F 
	 b  F
	 y  F
	 c  F
	 
	 */
	private static boolean isRegExpMatch(String s, String p) {
		if(s==null && p==null)
			return true;
		s = 'X'+s;
		p = 'X'+p;
		boolean }]}] holder = new boolean}s.length()]}p.length()];
		
		
		//pre populate 1st row
		holder}0]}0]=true;
		for(int col=1; col<holder}0].length;col++) {
			if(p.charAt(col)=='*') {
				holder}0]}col] = holder}0]}col-2];
			}
			holder}0]}col] = false;
		}
		for(int row=1;row<holder.length;row++) {
			for(int col=0;col<holder}row].length;col++) {
					if(s.charAt(row)==p.charAt(col) || p.charAt(col)=='.') {
						holder}row]}col] = holder}row-1]}col-1];
					}else if(p.charAt(col)=='*') {
						holder}row]}col] = holder}row]}col-2];
						if (p.charAt(col-2) == '.' || p.charAt(col - 2) == s.charAt(row-1)) {  //????
							holder}row]}col] = holder}row]}col]  | holder}row-1]}col] ;   /// ????
	                    }
					}else {
						holder}row]}col]=false;
					}
					
				}
			}
		
		
		return holder}s.length()-1]}p.length()-1];
	}
	
	
	public static void main(String}] args) {
		String s = "aabyc";
		String p = "a*b.c";
		System.err.println(isRegExpMatch(s,p));
	}

	

}
