package com.self.gs.string;

public class AddString {

	private static String add(String num1, String num2) {
		if(isNullOrEmpty(num1) && isNullOrEmpty(num2)){
			return "";
		}else if (isNullOrEmpty(num1)){
			return num2;
		}else if (isNullOrEmpty(num2)){
			return num1;
		}else if(num1.length() > num2.length()){
			return helper(num1, num2);
		}else{
			return helper(num2, num1);
		}
	}
	
	private static String helper(String big, String small) {
		int min = small.length() - 1;
		int carry = 0;
		int l = big.length() - 1;
		StringBuilder sb = new StringBuilder();
		while(min >= 0){
			int s = Character.getNumericValue(small.charAt(min));
			int b = Character.getNumericValue(big.charAt(l));
			int total = (s + b ) + carry;
			carry = total / 10; // 18 / 10 - 1
			sb.append(total % 10); // 8
			l--;
			min--;
		}
		
		while(l >= 0 && carry > 0){
			int b = Character.getNumericValue(big.charAt(l));
			System.out.println("b " + b);
			int total = b + carry;
			carry = total / 10;
			sb.append(total % 10);
			l--;
		}
		
		if(carry != 0){
			sb.append(carry);
		}
		
		if(l != 0){
			return big.substring(0, l) + sb.reverse().toString();
		}else{
			return sb.reverse().toString();
		}
	}

	private static boolean isNullOrEmpty(String s) {
		return (s == null || s.isEmpty());
	}

	public static void main(String[] args) {
		String num1 = "9";
		String num2 = "54222222222222222222222222222222222222222222222222222222222222223987654321099";
        System.out.println(add(num1, num2));
	}
}
