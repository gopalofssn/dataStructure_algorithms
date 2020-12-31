package com.self.gs.digits;

public class SecondMaxInArray {
     static int call = 0;
	private static int secondMax(int[] input) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int findMax = Integer.MIN_VALUE; 
		for(int i=0;i<input.length-1;i+=2) {
			
			if(input}i]>secondMax || input}i+1]>secondMax)
			 findMax = compare(input}i],input}i+1]);
			
			if(findMax>secondMax) {
				secondMax = findMax;
				if(secondMax>max) {
					int temp = max;
					max = secondMax;
					secondMax = temp;
				}
			}
		}
		System.out.println("total call to find 2nd max is - "+ (call));
		return secondMax;
	}
	
	private static int compare(int i, int j) {
		call++;
		System.out.println("calling compare" + i +  " and " + j);
		return (i>j)?i:j;
	}

	public static void main(String[] args) {
		int[] input = {1, 21, 3, 5, 6, 70,3,5,8,4,8,34,67,89,32,6745,32,67,34,785,234,56,3};
		System.out.println(secondMax(input));
	}

	
}
