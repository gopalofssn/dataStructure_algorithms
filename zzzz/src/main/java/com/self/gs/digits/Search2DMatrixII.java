package com.self.gs.digits;

public class Search2DMatrixII {

	 private class Cell{
	        int row;
	        int col;
	        Cell(int row, int col){
	            this.row = row;
	            this.col = col;
	        }
	        
	        public int getPosition(){
	            return (COL_LEN * row ) +  col ;
	        }
	    }
	    
	    private int ROW_LEN;
	    private int COL_LEN;
	    
	    public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix == null || matrix.length == 0) return false;
	        ROW_LEN = matrix.length;
	        COL_LEN = matrix[0].length;
	        
	        return binarySearchHelper(matrix, target, new Cell(0, 0), new Cell(ROW_LEN - 1, COL_LEN - 1));
	    }
	    
	    private boolean binarySearchHelper(int[][] matrix, int target, Cell topCell, Cell bottomCell){
	    	
	    	System.err.println("top pos " + topCell.getPosition() );
	    	System.err.println("bottom pos " + bottomCell.getPosition());
	    	
	        if(topCell.getPosition() > bottomCell.getPosition()){
	            return false;
	        }
	        
	        int midRow = (topCell.row + bottomCell.row) / 2; // ?
	        int midCol = (topCell.col + bottomCell.col) / 2;  // ?
	        System.err.println("midRow - " + midRow );
	        System.err.println("midCol - " + midCol );
	        
	        if(target == matrix[midRow][midCol]){
	            return true;
	        }else if(target > matrix[midRow][midCol]){
	            return binarySearchHelper(matrix, target, topCell, new Cell(midRow, midCol + 1));
	        }else{
	            return binarySearchHelper(matrix, target, new Cell(midRow, midCol - 1), bottomCell);
	        }
	        
	    }
	    
	public static void main(String[] args) {
		int[][] matrix = {
		                  {1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {10, 13, 14, 17, 24},
		                  {18, 21, 23, 26, 30}
		                };
		

		System.err.println(new Search2DMatrixII().searchMatrix(matrix, 5));
		
	}

}
