package com.self.gs.digits;

import java.util.Hashtable;

public class Fibonacci {
	
	private static int fib(int n,Hashtable<Integer, Integer>  memo) {
		if(n==0)
			return 0;
		else if(n<=2)
			return 1;
		
		int result = (memo.containsKey(n-1)?memo.get(n-1):fib(n-1,memo))
				     +
				     (memo.containsKey(n-2)?memo.get(n-2):fib(n-2,memo));
        memo.put(n, result);
		System.out.println(n);
		return result;
	}
	
  public static void main(String[] args) {
	  Hashtable<Integer, Integer>  memo =  new Hashtable<Integer, Integer>();
	System.out.print(fib(20,memo)); // 0 1 1 2 3 5 8 13
}


}
