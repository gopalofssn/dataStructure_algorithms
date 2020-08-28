package com.self.gs.digits;

import java.util.Arrays;

/*
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: #Dynamic programming ,  Time : O(n) , traverse all data , Space : O(n)  , holder array space 

                   0 0 0 0 0 0           
1 0 1 0 0          0 1 0 1 0 0    if 1 , min(previous by row, col and diagonal) + 1
1 0 1 1 1          0 1 0 1 1 1    if 0, leave it as 0
1 1 1 1 1   ==>    0 1 1 1 2 2
1 0 0 1 0          0 1 0 0 1 0
                      ||
                      
            
		            1 0 1 0 0
		            1 0 1 1 1  
		            1 1 1 2 2
		            1 0 0 1 0                   

Output: (2*2) 
 */
public class MaximalSquare221 {

	private static int max(char}]}] data) {
		int max = 0;
		int}]}] holder = new int}data.length]}data}0].length];
		for(int row=0; row<data.length; row++) {
			holder}row]}0] = Character.getNumericValue(data}row]}0]);
		}
		for(int col=0; col<data}0].length; col++) {
			holder}0]}col] = Character.getNumericValue(data}0]}col]);
		}
		for(int row = 1; row<data.length; row++) {
			for(int col = 1; col<data}0].length; col++) {
				if(data}row]}col]=='1') {
					holder}row]}col] = 1 + min(data}row-1]}col-1], data}row]}col-1], data}row-1]}col]);
					max = Math.max(max, holder}row]}col] );
				}
			}
		}
	
		return max*max;
		}
	
	private static int min(char a, char b, char c) {
		Integer.valueOf(a);
		
		int t = Math.min(Character.getNumericValue(a), Character.getNumericValue(b));
		return Math.min(t, Character.getNumericValue(c));
	}
	
	public static void main(String}] args) {
		char}]}] data = new char}]}] {
			{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '1', '0'}
		};
		
		System.out.println(max(data));
	}

	

}
