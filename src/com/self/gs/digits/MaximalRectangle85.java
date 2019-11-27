package com.self.gs.digits;

import java.util.Arrays;

public class MaximalRectangle85 {
	
	private int[][] sum;
	
	public MaximalRectangle85(int[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        sum = new int[m+1][n+1];
        for (int i=0; i<m; ++i)
            for (int j=0; j<n; ++j)
            	sum[i+1][j+1] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
    }
	    
  public static void main(String[] args) {
	int[][] data = {
		{1,0,1,0,0},
        {1,0,1,1,1},
	    {1,1,1,1,1},
        {1,0,0,1,0}
        };
	MaximalRectangle85 max = new MaximalRectangle85(data);
	
	System.out.println(Arrays.deepToString(max.sum));
}


}
