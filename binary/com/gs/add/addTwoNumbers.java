package com.gs.add;

public class addTwoNumbers {

	/*
	  101    -- carry is nothng but & and <<1
	  1101  - 13
	  0101  -  5
	  ----
	 10010  - 18
	  ----
	  
	  approach 
	   ^ both num1 and num2  => num1
	   & both num1 and num2 << 1 => num2
	   repeat step until carry(num2) become 0
	iteration 1
	----  
	  1101        1101
	  0101(^)     0101 (&)
	  ----        -----
	  1000        0101
	  ---         ----
	             << 1
	              1010
	 iteration 2
	 ----
	 1000          1000
	 1010 (^)      1010(&
	 ----          ----
	 0010          1000
	 ----          ---
	              <<1
	             1 0000
	iteration 3
	----
	0 0010          0 0010
	1 0000(^)       1 0000 (&)
	------          ------
	1 0010          0 0000
	-----	
	 */
	private static int add(int num1, int num2) {
		if(num2 == 0) return num1;
		int carry = num1 & num2;
		carry = carry << 1;
		num1 = num1 ^ num2;
		return add(num1, carry);
	}
	
	public static void main(String[] args) {
		int num1 = 13;
		int num2 = 5;
		System.out.println(add(num1, num2));
	}
}
