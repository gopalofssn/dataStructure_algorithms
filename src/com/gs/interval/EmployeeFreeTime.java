package com.gs.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
	private static int[][] findFreeTime(int[][][] schedule) {
		if(schedule == null || schedule.length == 0) return new int[0][];
		int[][] periods = consolidateAllPeriodsByEarlyStart(schedule);
		List<int[]> freeTimeList = new ArrayList<int[]>();
		findFreeTime(periods, freeTimeList);
		return convertAndSend(freeTimeList);
	}

  private static int[][] convertAndSend(List<int[]> freeTimeList) {
	  int[][] result = new int[freeTimeList.size()][];
	  int counter = 0;
	  for(int[] free : freeTimeList){
		  result[counter++] = free;
	  }
	  return result;
	}

  private static List<int[]> findFreeTime(int[][] periods, List<int[]> freeTimeList) {
	  for(int i = 1; i < periods.length; i++){
		  int[] prev = periods[i -1];
		  int[] current = periods[i];
		  if(!isConflict(prev, current)){
			  freeTimeList.add(new int[]{prev[1], current[0]});
		  }
	  }
	  return freeTimeList;
	}

	private static boolean isConflict(int[] prev, int[] current) {
		if(prev[1] > current[0]) return true;
		if(prev[0] < current[0] && prev[1] > current[1]) { // inbetween case
			return true;
		}
		return false;
	}

	private static int[][] consolidateAllPeriodsByEarlyStart(int[][][] schedules) {
	  	Comparator<int[]> cmp =  new Comparator<int[]>() { // we need to check if both start time same 
	  		public int compare(int[] a, int[] b){
	  			int diff = a[0] - b[0];
	  			if(diff != 0) return diff;
	  			diff = a[1] - b[1];
	  			return diff;
	  		}
		};
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(cmp);
		for(int[][] schedule : schedules){
			for(int[] period : schedule){
				queue.offer(period);
			}
		}
		int[][] result = new int[queue.size()][];
		//queue.toArray(result); // bad idea , not give sorted array
		int counter = 0;
		while(!queue.isEmpty()){
			result[counter++] = queue.poll();
		}
		return result;
	}

  private static void print(int[][] periods) {
		for(int[] period : periods){
			 System.out.println(Arrays.toString(period));
		 }
	}
  
public static void main(String[] args) {
	   // find common free time - GOOD
	  // find free time between employee 1 & 2, 2 & 3
    	int[][][] schedule ={
    							{{1,2}, {5,6} },
    							{ {1,3 } },
    							{ {4, 10} }
    						};
    	int[][] freeTime = findFreeTime(schedule);
    	print(freeTime);
  }


}
