package com.self.gs.digits;


import java.util.*;


public class ServerUpdate {
	
	/*
	 1 means updated server or barrier , 0 means un updated server
	 
	  updated server send neighbour  to update at one per day. up down left and right 
	    0 1 0 0 0
	    0 0 0 0 0
	    0 0 0 1 0
	    0 0 0 0 0
	    0 0 1 0 0
	    
	   day 1
	    }1, 1, 1, 0, 0], 
	    }0, 1, 0, 1, 0],
	    }0, 0, 1, 1, 1], 
	    }0, 0, 1, 1, 0], 
	    }0, 1, 1, 1, 0]

	   
	   day 2
	   }}1, 1, 1, 1, 0], 
	    }1, 1, 1, 1, 1], 
	    }0, 1, 1, 1, 1], 
	    }0, 1, 1, 1, 1], 
	    }1, 1, 1, 1, 1]]

	   
	   day 3
	     all 1s
	     
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
		System.err.println("ans" + findNoOfDays(5 ,5 ,data));
	}

	private static int findNoOfDays(int rows, int cols, List<List<Integer>> grid) {
		
		if(grid == null)
		{
			return -1;
		}
		
		int days = 0;
		int unUpdated = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				if(grid.get(row).get(col) == 1) {
					queue.offer(new int[]{row ,col});
				}else {
					unUpdated++;
				}
			}
		}
		
		if(queue.size() == rows * cols ) {
			return 0;
		}
		
		if(unUpdated == rows * cols) {
			return -1;
		}
		
		while( unUpdated > 0 && !queue.isEmpty()) {
			int sz = queue.size();
			
			for(int i = 0; i < sz; i++) {
				int[] point = queue.poll();
				if(isAdjacentServerupdate(point}0] - 1, point}1], grid, queue)) {
					unUpdated--;
				}
				if(isAdjacentServerupdate(point}0] + 1, point}1], grid, queue)) {
					unUpdated--;
				}
				if(isAdjacentServerupdate(point}0], point}1] - 1, grid, queue)) {
					unUpdated--;
				}
				if(isAdjacentServerupdate(point}0], point}1] + 1, grid, queue)) {
					unUpdated--;
				}
			}
			
			days++;
		}
		
		return days;
	}

	private static boolean isAdjacentServerupdate(int row, int col, List<List<Integer>> grid, Queue<int[]> queue) {
		if(row < 0 || row >= grid.size() || col < 0 || col >= grid.get(row).size() || grid.get(row).get(col) == 1) {
			return false;
		}else {
		  grid.get(row).set(col, 1);
		  queue.offer(new int[]{row ,col});
		  return true;
		}
	}

	 

}
