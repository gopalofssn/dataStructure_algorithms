package com.self.gs.digits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

	/*
	E1: ----------            ----  
	E2:       --------   
	E3        ------------              -----------
	    1     2   3   4   5   6  7   8  9  10  11 12
	 */
	
	private static int[][] findFreeTime(int[][][] schedulePerEmployee) {
		
		if(schedulePerEmployee == null || schedulePerEmployee.length == 0) return new int[0][];
		
		
		List<int[]> scheduleList = new ArrayList<int[]>();
		
		for(int[][] schedule : schedulePerEmployee) {
			for(int[] period : schedule) {
				scheduleList.add(period);
			}
		}
		
		Comparator<int[]> cmp = ( (a, b) -> a[0] - b[0] );
		Collections.sort(scheduleList, cmp);
	 
		LinkedList<int[]> merged_intervals = new LinkedList<int[]>();
		merged_intervals.add(scheduleList.get(0));
		
		for(int i = 1; i < scheduleList.size(); i++) {
			int[] current = scheduleList.get(i);
			int[] last = merged_intervals.getLast();
			// overlap or within
			if(current[0] < last[1]) {
				last[1] = Math.max(current[1], last[1]);
			}else {
				merged_intervals.add(current);
			}
		}
		
		//List<int[]> freeList = new ArrayList<int[]>();
		int[][] result = new int[merged_intervals.size() - 1][];
		
		for(int i = 1; i < merged_intervals.size() ; i++) {
			int[] prev = merged_intervals.get(i - 1);
			int[] current = merged_intervals.get(i);
			result[i - 1] = (new int[] {prev[1], current[0]});
		}
		
		//int[][] result = new int[freeList.size()][];
		//freeList.toArray(result);
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int[][][] schedulePerEmployee = {
		                                 {{1,3},{6,7}},
		                                 {{2,4}},
		                                 {{2,5},{9,12}}
										};
		System.err.println(Arrays.deepToString(findFreeTime(schedulePerEmployee)));
		
	}

}
