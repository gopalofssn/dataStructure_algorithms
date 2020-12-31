package com.self.gs.digits;

public class AddBinaryNumbers {

	
	/*
	 11
	  1
	 --
	100
	---
	
	 1010
	 1011
	 ----
	10101
	 
	 */
	public static String addBinary(String a, String b) {
		
		if(a == null || a.trim().length() == 0) {
			return b;
		}
        
		if(b == null || b.trim().length() == 0) {
			return a;
		}
		
		int aRightIndex = a.length() - 1; 
		int bRightIndex = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		 
		while(aRightIndex >=0 || bRightIndex >=0 ) {
			
			int sum = carry;
			
			if(aRightIndex >= 0) {
				sum += a.charAt(aRightIndex--) - '0';
			}
			
			if(bRightIndex >= 0) {
				sum += b.charAt(bRightIndex--) - '0';
			}
			
			sb.append(sum % 2);
			carry = sum / 2;
			
		}
		
		if(carry == 1) {
			sb.append(carry);
		}
		return sb.reverse().toString();
    }

	public static void main(String[] args) {
		System.err.println(addBinary("1010","1011"));
		System.err.println(addBinary("11"," "));
	}

}
