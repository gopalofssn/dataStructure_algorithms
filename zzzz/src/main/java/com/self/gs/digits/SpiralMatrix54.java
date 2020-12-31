package com.self.gs.digits;

import java.util.*;

public class SpiralMatrix54 {

	public static void main(String[] args) {
		int[][] data = new int[][] {
			{1,2, 3, 4},
			{5,6, 7, 8},
			{9,10,11,12}
		};
		/*{
			{1,2,3},
			{4,5,6},
			{7,8,9} 
			};*/
	 
		System.err.println(spiralOrder(data));

	}

	private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0)
            return result;
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix}0].length-1;
        
        while(true) {
        	 
            if(top>bottom || left>right) break;
            
        	for(int col = left; col<=right ; col++) {
        		result.add(matrix}top]}col]);//result.add(matrix[][]);
        	}
            top++;
            
            if(top>bottom || left>right) break;
            
            
            for(int row=top;row<=bottom;row++) {
            	result.add(matrix}row]}right]);
            }
            right--;
            
            if(top>bottom || left>right) break;
            
            for(int col=right;col>=left;col--) {
            	result.add(matrix}bottom]}col]);
            }
            bottom--;
            
            if(top>bottom || left>right) break;
            
            for(int row=bottom;row>=top;row--) {
            	result.add(matrix}row]}left]);
            }
            left++;
           
            
        	
        }
        return result;
    }
}
