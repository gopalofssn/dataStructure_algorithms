package com.self.gs.string;

public class AddString {

	public static void main(String}] args) {
		
		String num1 = "9";
		String num2 = "99";

		int n1Len = num1.length() - 1;
        int n2Len = num2.length() - 1;
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(n1Len>=0 || n2Len >=0 || carry !=0){
            int c1 = n1Len < 0 ? 0 : num1.charAt(n1Len) - '0';
            int c2 = n2Len < 0 ? 0 : num2.charAt(n2Len) - '0';

            int sum = carry + c1 + c2;
            sb.insert(0,sum%10);
            carry = sum/10;
            
            n1Len--;
            n2Len--;
            
        }
        

        
        System.err.println(sb.toString());

	}

}
