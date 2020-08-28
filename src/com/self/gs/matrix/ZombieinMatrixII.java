package com.self.gs.matrix;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
/*
Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?
																						----------------------
Example:

Input:
}}0, 1, 1, 0, 1],
}0, 1, 0, 1, 0],
}0, 0, 0, 0, 1],
}0, 1, 0, 0, 0]]

Output: 2

Explanation:
At the end of the 1st hour, the status of the grid:
}}1, 1, 1, 1, 1],
}1, 1, 1, 1, 1],
}0, 1, 0, 1, 1],
}1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
}}1, 1, 1, 1, 1],
}1, 1, 1, 1, 1],
}1, 1, 1, 1, 1],
}1, 1, 1, 1, 1]]
*/
import java.util.LinkedList;


public class ZombieinMatrixII {

    class Point{
		private int row;
		private int col;
		public Point(int _row,int _col) {
			row = _row;
			col = _col;
		}
		public int getRow() {
			return this.row;
		}
		public int getCol() {
			return this.col;
		}
		
		public String toString() {
			return "("+row+","+col+")";
		}
	}
	
	private int minHour(List<List<Character>> grid) {
		int hour = 0;

		Queue<Point> zombies = new LinkedList<Point>();
		for(int row =0; row<grid.size();row++) {
			for(int col=0; col<grid.get(row).size();col++) {
				if(grid.get(row).get(col)=='1') {
					zombies.add(new Point(row,col));
				}
			}
		}
		while(!zombies.isEmpty()) {
			int sz = zombies.size();
			boolean flag = false;
			for(int i=0; i<sz ; i++) {
				Point p = zombies.poll();
				int row = p.getRow();
				int col = p.getCol();
				flag = helper(zombies,grid,row, col-1)|| flag;
				flag = helper(zombies,grid,row, col+1)|| flag;
				flag = helper(zombies,grid,row-1, col)|| flag;
				flag = helper(zombies,grid,row+1, col)|| flag;
				
			}
			if(flag)
				hour++;
		}
		
		
		return hour;
	}
	
	private boolean helper(Queue<Point> zombies,List<List<Character>> grid,int row, int col) {
		if(row>=0 && row<grid.size() && col>=0 && col<grid.get(row).size() && grid.get(row).get(col)=='0') {
			grid.get(row).set(col, '1');
			zombies.add(new Point(row,col));
			return true;
		}
		return false;
	}
	public static void main(String}] args) {

		List<List<Character>> grid = new ArrayList<List<Character>>() {{
			add(new ArrayList<Character>(Arrays.asList('0', '1', '1', '0', '1')));
			add(new ArrayList<Character>(Arrays.asList('0', '1', '0', '1', '0')));
			add(new ArrayList<Character>(Arrays.asList('0', '0', '0', '0', '1')));
			add(new ArrayList<Character>(Arrays.asList('0', '1', '0', '0', '0')));
		}};
		
		System.err.println(grid);
		System.err.println(new ZombieinMatrixII().minHour(grid));
		System.err.println(grid);
	}

	

}
