package com.gs.iterator;

import java.util.Iterator;

public class TwoDArrayIterator implements Iterator<Integer>{

	private int[][] grid;
	private int row;
	private int col;
	public TwoDArrayIterator(int[][] grid) {
		this.grid = grid;
		this.row = 0;
		this.col = 0;
	}
	
	@Override
	public boolean hasNext() {
		if(row < grid.length && grid[row] != null && col >= grid[row].length) {
			col = 0;
			row++;
			return hasNext();
		}
		
		if(row >= grid.length) {
			return false;
		}
		
		if(grid[row] == null || grid[row].length == 0) {
			row++;
			return hasNext();
		}
		return true;
	}

	@Override
	public Integer next() {
		if(hasNext()) {
		 int currentCol = col;
		 col++;
		 return grid[row][currentCol];
		}
		
		return null;
	}

	public static void main(String[] args) {
		int[][] grid = {
						{1,2,3},
						null,
						{4,5,6},
						{7,8}
		               };
		Iterator iterator = new TwoDArrayIterator(grid);
		while(iterator.hasNext()) {
			System.err.println(iterator.next());
		}
	}

}
