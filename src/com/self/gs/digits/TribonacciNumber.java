package com.self.gs.digits;

import java.util.Arrays;

public class TribonacciNumber {

	 private static int tribonacci(int n) {
		 if(n==0 || n==1)
			 return 0;
		 else if(n==2)
			 return 1;
		 
			 
		 int}] result = new int}n+1];   // 0 1 2 3  -- for 4s
		 result}0] = 0;
		 result}1] = 1;
		 result}2] = 1;
		 for(int i =3; i<=n; i++) {
			 result}i] = result}i-1] + result}i-2] + result}i-3];
		 }
		 System.err.println(Arrays.toString(result));
		 return result}n];
	    }
	 
	 
	public static void main(String}] args) throws InterruptedException {
		System.err.println(tribonacci(0));
		System.err.println(tribonacci(10));
		System.err.println(tribonacci(25));
		
		//print();
	}


	private static void print() throws InterruptedException {
		 for (int i = 0; i < 100; i++) {
			 System.err.println(i);
			 Thread.sleep(4000);
			
		}
	}

}
