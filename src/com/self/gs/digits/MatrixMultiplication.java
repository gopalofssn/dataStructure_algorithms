package com.self.gs.digits;

import java.util.Arrays;

public class MatrixMultiplication {

	/*
	 (2X3)*(3X3) = (2X3)
	  -       -
	 */
	private static int}]}] multiplay(int}]}] a, int}]}] b) {
		int}]}] result = new int}a.length]}b}0].length];
		
		for(int row=0;row<result.length;row++) {
			for(int col=0;col<result}0].length;col++) {
					result}row]}col] = calculateCellValue(a,b,row,col);
			}
		}
		return result;
	}
	
	private static int calculateCellValue(int}]}] a, int}]}] b, int row, int col) {
        int val =0;
        for(int i=0;i<b.length;i++) {
        	val += a}row]}i]*b}i]}col];
        }
		return val;
	}

	public static void main(String}] args) {
		int}]}] a = new int}]}] {
			{1 ,2,-3},
			{-1,5, 3}
		};
		
		int}]}] b = new int}]}] {
			{7,0,9},
			{9,3,0},
			{7,0,1}
		};
		
		System.out.println(Arrays.deepToString( multiplay(a,b)));
	}

}
