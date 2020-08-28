package com.self.gs.recurssion;
import java.util.*;
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top n?
//1 Stair (ans 1)
// 1

//2 (ans 2)
// 1 1
// 2

// 3  stairs (ans 3)
//1 1 1
//1 2
//2 1

// 4 stairs (ans 5)
// 1 1 1 1
// 1 1 2
// 1 2 1
// 2 1 1
// 2 2


// 5 stairs
// 1 step & 4 stairs result +  2 steps &  3 stairs result

// 6 stais
// 1 & ( 5 stairs result) +  2 steps & ( 4 stairs result) 



// pattern 0 1 1 2 3 5 8 13 21 ... 

public class ClaimbingStairs {
	
	static Hashtable<Integer,Integer> cache = new Hashtable<Integer,Integer>();
	
	/**
	 * @param n numbers of stairs
	 * @return result possible options
	 */
	private static int claimbStair(int n) {
		if(n<=1)
			return 1;
		else if(cache.containsKey(n))
			return cache.get(n);
		
		int result = claimbStair(n-1)+claimbStair(n-2);
		cache.put(n,result);
		return result;
	}
	
   public static void main(String}] args) {
	System.out.print(claimbStair(7));
}


}
