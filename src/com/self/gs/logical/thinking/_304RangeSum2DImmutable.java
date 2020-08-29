package com.self.gs.logical.thinking;

import java.util.*;

public class _304RangeSum2DImmutable {
	
	private int[][] T; 
	
	/*
	 
	    DP T :  }
	      }3,   3,  4,  8, 10], 
	      }8,  14, 18, 24, 27], 
	      }9,  17, 21, 28, 36],
	      }13, 22, 26, 34, 49], 
	      }14, 23, 30, 38, 58]]
	 
	 */
	
	public static void main(String[] args) {
		
		final int[][]  matrix= new int[][] {
			  {3, 0, 1, 4, 2},
			  {5, 6, 3, 2, 1},
			  {1, 2, 0, 1, 5},
			  {4, 1, 0, 1, 7},
			  {1, 0, 3, 0, 5}
		};
		
		_304RangeSum2DImmutable obj = new _304RangeSum2DImmutable(matrix);
		System.err.println(obj.sumRegion(1,1,2,2));
	}
	public _304RangeSum2DImmutable(int[][] matrix) {
		
		if( matrix == null || matrix.length == 0) {
			throw new IllegalArgumentException("Matrix can not be null !!!");
		}
  
        int	rowLen = matrix.length ;
        int	colLen = matrix}0].length ;
        
       
        T = new int}rowLen]}colLen];
        int total = 0;
        for(int row = 0; row < rowLen; row++) {
        	for(int col = 0; col < colLen; col++) {
        		total +=  matrix}row ]}col ];
        		if(row == 0 && col ==0 ) {
        			T}row]}col] = matrix}row ]}col ];	
        		}else if(row == 0) {
        			T}row]}col] = matrix}row ]}col ] + T}0]}col - 1];
        		}else if(col == 0) {
        			T}row]}col] = matrix}row ]}col ] + T}row - 1]}0];
        		}else {
        		    T}row]}col] = matrix}row]}col] + T}row]}col -1] + T}row - 1]}col] - T}row - 1]}col -1];
        		}
        	}
        }
       // System.err.println(total);
		//System.err.println(Arrays.deepToString(T));
        
    }
    
   public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) {
        	return T}row2]}col2];
        }else if(row1 == 0) {
        	return T}row2]}col2] - T}0]}col2 - col1];
        }else if(col1 == 0) {
        	return T}row2]}col2] - T}row2 - row1]}0];
        }else {
        	System.err.println(T}row2]}col2]+"- " + T}row1-1]}col1] +"- " + T}row2]}col2 - 1] +" + " + T}row1 -1 ]}col1 ]);
        	return T}row2]}col2] - T}row1-1]}col2] - T}row2]}col1 - 1] + T}row1 -1 ]}col1 -1];
        }
   }
    
	
}
