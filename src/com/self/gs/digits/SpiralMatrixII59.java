package com.self.gs.digits;

import java.util.Arrays;

public class SpiralMatrixII59 {

	
   public static int[][] generateMatrix(int n) {
        if(n==0)
        	return null;
       int matrix[][] = new int[n][n];
       int top =0;
       int bottom = n-1;
       int left =0;
       int right = n-1;
       int val = 1;
       while(true) {
    	   if(left>right || top>bottom) break;
    	   for(int col=left;col<=right;col++)
    		   matrix[top][col] = val++;
    	   top++;
    	   
    	   if(left>right || top>bottom) break;
    	   for(int row=top;row<=bottom;row++)
    		   matrix[row][right] = val++;
    	   right--;
    	   
    	   if(left>right || top>bottom) break;
    	   for(int col=right;col>=left;col--)
    		 matrix[bottom][col] = val++;
    	   bottom--;
    	   
    	   if(left>right || top>bottom) break;
    	   for(int row=bottom;row>=top;row--)
    		   matrix[row][left]= val++;
    	   left++;
    	   
       }
       return matrix;
    }

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(generateMatrix(3)));
	}

}
