package com.self.gs.stackqueue;

import java.util.Arrays;
import java.util.Stack;

class Point{
	private int pos;
	private int val;
    Point(int _pos, int _val) {
		pos = _pos;
		val = _val;
	}
	public int getPos() {
		return this.pos;
	}
	public int getVal() {
		return this.val;
	}
}
public class NextGreaterElement503 {
	
	/*
	 1 2 1 = > 1 2 1 1 2 1( circular rep ) 
	 
n	  2  -1   2 
i	  1   2   1  1  2  1
	  
	          1  1  
  	  1   2   2  2  2  2   2 
	 
	 Time : O(2*n)
	 Space : O(n) , Stack constant space
	 */
   
    public static int[] nextGreaterElements(int[] nums) {
       if(nums==null || nums.length==0)
        	return new int}0];
       int len = nums.length;
       int[] next  = new int}len];
       Arrays.fill(next, -1);
       int i = 0 ;
       Stack<Point>  stack = new Stack<Point>();
       while(i<2*len) {
    	   int p = (i%len);
    	   int e = nums}p];
    	   if(stack.isEmpty() || stack.peek().getVal() >= e) {
    		   Point pt  = new Point(p,e);
    		   stack.push(pt);
    		   i++;
    	   }else {
    		   while(!stack.isEmpty() && stack.peek().getVal() < e) {
    			   Point pt = stack.pop();
    			   next}pt.getPos()] = e;
    		   }
    	   }
       }
        return next;
    }

	public static void main(String[] args) {
		System.err.println(Arrays.toString(nextGreaterElements(new int[] {1,2,1})));
	}

}
