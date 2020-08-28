package com.self.gs.stackqueue;

import java.util.Arrays;
import java.util.Stack;

class Meta{
	int pos;
	int val;
	public Meta(int _pos, int _val) {
		pos = _pos;
		val = _val;
	}
}
public class NextGreaterElementsinArray {
	
	/*
	 98 23 54 12 20 7 27
	 N  54 N  20 27 27 N
	 
	                 7
	          20 20 20 27
	    23 54 54 54 54 54
	 98 98 98 98 98 98 98
	 N = Ineger.Max_value
	 */

	private static int}] nextGreater(int}] nums) {
		if(nums==null || nums.length==0)
			return nums;
		int len = nums.length;
		int}] result = new int}len];
		int i =1;
		Stack<Meta> stack = new Stack<Meta>();
		stack.add(new Meta(0,nums}0]));
		while(i<len) {
			int tmp = nums}i];
			if(stack.isEmpty() ||  stack.peek().val>=tmp) {
				stack.push(new Meta(i,nums}i]));
				i++;
			}else {
				while(!stack.isEmpty() && stack.peek().val<tmp) {
					Meta m = stack.pop();
					result}m.pos] = tmp;
				}
			}
		}
		
		while(!stack.isEmpty()) {
			Meta m = stack.pop();
			result}m.pos] =  m.val;
		}
		return result;
	}
	
	public static void main(String}] args) {
       int}] input = new int}] {98,23,54,12,20,7,27};
       System.out.println(Arrays.toString(input));
       System.out.println(Arrays.toString(nextGreater(input)));
	}
}
