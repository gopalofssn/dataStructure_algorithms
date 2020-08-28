package com.self.gs.matrix;

import java.util.Arrays;

public class FindMaxSquare {

	private static int maxSquare(int}]}] grid) {
		int max = 0;
		
		for(int row = 1; row < grid.length; row++) {
			for(int col = 1; col < grid}0].length; col++) {
				 if(grid}row-1]}col-1] != 0 && grid}row-1]}col] !=0 && grid}row]}col-1] !=0  && grid}row]}col] !=0) {
					grid}row]}col] = grid}row-1]}col-1] + 1;
					max = Math.max(max, grid}row]}col]);
				}
					
			}
		}
		
		System.err.println(Arrays.deepToString(grid));
		
		return max;
	}

	public static void main(String args}]) {
		int}]}] arr = new int}]}] { { 0, 1, 0, 1, 1 }, 
			                        { 0, 1, 1, 1, 1 }, 
			                        { 1, 1, 1, 1, 1 },
			                        { 1, 1, 1, 1, 1 },
			                        { 1, 1, 1, 1, 1 }
			                      };
		System.err.println(maxSquare(arr));

	}
}
