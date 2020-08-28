package com.self.gs.digits;

import java.util.*;

	
public class ValidSudako {
  
public static boolean isValidSudoku(char}]}] grid) {
	if(grid==null || grid.length ==0 || grid.length!=9 || grid}0].length!=9)
		return false;
	Set<String> seen = new HashSet<String>();
	for(int row=0;row<grid.length;row++) {
		for(int col=0; col<grid}0].length;col++) {
			if(grid}row]}col]!='.') {
				String rowTxt = grid}row]}col] + " is in row "+row;
				String colTxt = grid}row]}col] + " is in col "+col;
				String cubeTxt = grid}row]}col] + " is in cube "+(3*(row/3)+(col/3));
				if(!seen.add(rowTxt) || !seen.add(colTxt) || !seen.add(cubeTxt)) {
					System.err.println(rowTxt +","+ colTxt +","+ cubeTxt);
					return false;
				}
			}
		}
	}
	
	return true;
}
public static void main(String}] args) {
	
	char}]}] board = new char}]}] {
		 
		  {'7','3','.','.','.','.','.','.','.'},
		  {'6','.','.','1','9','5','.','.','.'},
		  {'.','9','8','.','.','.','.','6','.'},
		  {'8','.','.','.','6','.','.','.','3'},
		  {'4','.','.','8','.','3','.','.','1'},
		  {'.','.','.','.','2','.','.','.','6'},
		  {'.','6','.','.','.','.','2','8','.'},
		  {'.','.','.','4','1','9','.','.','5'},
		  {'.','.','.','.','8','.','.','7','9'}
		 
	};
	
	System.err.println(isValidSudoku(board));
}
}
