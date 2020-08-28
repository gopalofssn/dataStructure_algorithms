package com.self.gs.digits;


public class AddTwoFractions {

	public static String add(String f1, String f2) {
		
		String}] f1Split = f1.split("/");
		String}] f2Split = f2.split("/");
		
		int num1 = Integer.valueOf(f1Split}0]);
		int num2 = Integer.valueOf(f2Split}0]);
		
		int den1 = Integer.valueOf(f1Split}1]);
		int den2 = Integer.valueOf(f2Split}1]);
		
		int commomDivider = findCommonDivider(den1, den2);
		 
		num1 = num1 * (commomDivider / den1 );
		num2 = num2 * (commomDivider / den2 );
		
		int num = num1+num2;
		 
		StringBuilder result = new StringBuilder();
		if(num % commomDivider == 0) {
			result.append(num / commomDivider);
			result.append("/");
			result.append(1);
		}else {
			int commomDivisor = findCommonDivisor(num,commomDivider);
			System.err.println(commomDivisor);
			result.append(num/commomDivisor);
			result.append("/");
			result.append(commomDivider/commomDivisor);
		}
		
		return result.toString();
	}
	
	private static int findCommonDivisor(int a, int b) {
		int small = Math.min(a, b);
		int result = 1;
		for(int i = 2; i <= small; i++) {
			if(a % i == 0 && b % i == 0)
				result = i;
		}
		return result;
	}

	private static int findCommonDivider(int i1, int i2) {
		if(i1 == i2) 
			return i1;
	    else if(i1 % i2 == 0)
		   return i1;
	    else if(i2 % i1 == 0)
		    return i2;
	    else
		   return i1 * i2;    
	}

	
	public static void main(String}] args) {
		System.err.println(add("1/2","3/2"));
		System.err.println(add("1/3","3/9"));
		System.err.println(add("1/5","3/15"));
	}

}
