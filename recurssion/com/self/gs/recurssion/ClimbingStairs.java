package com.self.gs.recurssion;
import java.util.*;
public class ClimbingStairs {
	/*
	 4 steps can be climbed 
	   1 1 1 1
	   1 2 1
	   1 1 2
	   2 1 1
	   2 2
	 */
	private static int climbStairs(int n) {
		Map<Integer,Integer> memo  = new HashMap<Integer,Integer>();
		return helper(0, n, memo);	
	}

	private static int helper(int i, int n,Map<Integer,Integer> memo) {
		if(i>n) return 0;
		if(i==n) return 1;
		if(memo.containsKey(i)) return memo.get(i);	
		//System.err.println("calculating when at " + i);
		int result = helper(i + 1 ,n ,memo) + helper(i + 2 ,n ,memo);
		memo.put(i, result);
	    return result;
	}
   public static void main(String[] args) {
		System.err.println(climbStairs(4));
	}
}
