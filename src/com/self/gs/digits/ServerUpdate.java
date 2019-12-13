package com.self.gs.digits;

import java.util.*;

public class ServerUpdate {

	/*
	 1 means updated server or barrier , 0 means un updated server
	 
	 once u start update , it end when u find 1
	 */
	public static void main(String[] args) {
		List<List<Integer>> data = new ArrayList<List<Integer>>();
		data.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)));
		data.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
		data.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1, 0)));
		data.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
		data.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 0)));
		System.err.println(data);
		System.err.println("*****");
		System.err.println(findNoOfDays(data));
	}

	private static int findNoOfDays(List<List<Integer>> grid) {
		int result = 0;
		for(int row=0; row<grid.size();row++) {
			for(int col=0;col<grid.get(row).size();col++) {
				if(grid.get(row).get(col)==1) {
					result++;
					dfs(grid,row,col);
					System.err.println(grid);
				}
			}
		}
		
		return result;
	}

	private static void dfs(List<List<Integer>> grid, int row, int col) {
		 if(row>=grid.size() || row<0 || col<0 || col >=grid.get(row).size() || grid.get(row).get(col)==1)
			 return;
		 grid.get(row).set(col,1);
		 dfs(grid,row+1,col);
		 dfs(grid,row-1,col);
		 dfs(grid,row,col-1);
		 dfs(grid,row,col+1);	
	}

}
