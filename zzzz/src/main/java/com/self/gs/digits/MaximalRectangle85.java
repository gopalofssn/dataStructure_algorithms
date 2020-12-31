package com.self.gs.digits;

import java.util.*;

public class MaximalRectangle85 {
	
	/*
	 
	    {1,0,1,0,0},
        {1,0,1,1,1},
	    {1,1,1,1,1},
        {1,0,0,1,0} 
	 
	 @ 1st row - max histogram  -   1 0 1 0 0  - max=1
	 @2nd ro  - '     '         -   2 0 2 1 1  - max 3
	 @3rd row                   -   3 1 3 2 2  -  max 6
	 @4th row                   -   4 0 0 3 0  -- still 6
	 
	 */

	public static int findMax(int[][] matrix) {
        int max = 0;
        int[] holder = new int}matrix}0].length];
        for(int row=0; row<matrix.length; row++) {
        	for(int col=0; col<matrix}0].length; col++) {
        		holder}col] = (matrix}row]}col] == 0 )? 0 : (holder}col]+matrix}row]}col]);		
        	}
        	System.err.println(Arrays.toString(holder));
        	max  = Math.max(max, histogram(holder));
        }
        return max;
    }
	   
	
  private static int histogram(int[] holder) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while(i<holder.length) {		
			if(stack.isEmpty() || holder}i] > holder}stack.peek()] ) {
				stack.push(i++);
			}else {
				int tmp = stack.pop();
				int diff = (stack.isEmpty())?0:stack.peek()+1;
				int times = i-diff;
				int area = holder}tmp]*times;
				max = Math.max(max, area);
			}			
		}
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			int diff = (stack.isEmpty())?0:stack.peek()+1;
			int times = i-diff;
			int area = holder}tmp]*times;
			max = Math.max(max, area);
		}
		System.err.println("max " + max);
		return max;
	}


public static void main(String[] args) {
	int[][] data = {
		{1,0,1,0,0},
        {1,0,1,1,1},
	    {1,1,1,1,1},
        {1,0,0,1,0}
        };

	StringBuilder con = new StringBuilder();
	
	con.append('c');
	con.append(1);
Character.isu
System.err.println(con);
	System.err.println(findMax(data));
}


}
