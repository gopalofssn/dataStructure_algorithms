package com.self.gs.digits;

import java.util.*;

import com.self.gs.utils.PreetyPrint;

public class ValidSudako {
  
public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new TreeSet<String>();
        for(int row=0;row<board.length;row++) {
        	for(int col=0;col<board[row].length;col++) {
        		if(board[row][col]!='.') {
        			                                                           // on first row content stored in hashset 
        			String rowText = board[row][col]+ " is in "+row+"th row"; // 5 is in 0th row
        		    String colText = board[row][col]+ " is in "+col+"th column"; // 3 is in 1st column
        		    String cubeText = board[row][col]+ " is in cube "+ (3*(row/3)+(col/3)); // 7 is in cube 1 # (0/3)+(4/3) 
        		    
        		    if(!seen.add(rowText) || !seen.add(colText) || !seen.add(cubeText)) {
        		    	PreetyPrint.print(seen);
        		      return false;
        		    }
        			
        		}
        	}
        }
        PreetyPrint.print(seen);
	return true;
    }
public static void main(String[] args) {
	
	char[][] board = new char[][] {
		 
		  {'7','3','.','.','7','.','.','.','.'},
		  {'6','.','.','1','9','5','.','.','.'},
		  {'.','9','8','.','.','.','.','6','.'},
		  {'8','.','.','.','6','.','.','.','3'},
		  {'4','.','.','8','.','3','.','.','1'},
		  {'7','.','.','.','2','.','.','.','6'},
		  {'.','6','.','.','.','.','2','8','.'},
		  {'.','.','.','4','1','9','.','.','5'},
		  {'.','.','.','.','8','.','.','7','9'}
		 
	};
	
	System.err.println(isValidSudoku(board));
}
}
