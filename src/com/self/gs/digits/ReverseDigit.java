package com.self.gs.digits;

public class ReverseDigit {
	
	public static void main(String[] arg) {
		int num = 7456812;
		int reversed = 0;
		
	   while(num > 0) {
			reversed = (reversed*10) + (num%10);
			num = num / 10;
		}
		
		System.out.print(reversed);
	}
}
