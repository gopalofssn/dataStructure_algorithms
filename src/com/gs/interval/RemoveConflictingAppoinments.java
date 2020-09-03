package com.gs.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RemoveConflictingAppoinments {

	private static int[][] removeConflictAppoinement(int[][] appointments) {
		Comparator<int[]> cmp = ( (a, b) -> (a[0] > b[0]) ? 1 : -1 );
		Arrays.sort(appointments, cmp);
		int prev = 0;
		List<int[]> nonConflictList = new ArrayList<int[]>();
		nonConflictList.add(appointments[prev]);
		List<int[]> conflictList = new ArrayList<int[]>();
		for(int current = 1; current < appointments.length ; current++){
			if(!isConflict(nonConflictList.get(prev) , appointments[current])){
				nonConflictList.add(appointments[current]);
				prev++;
			}else{
				conflictList.add(appointments[current]);
			}
		}
		System.out.println(" removed appoinments ... ");
		for(int[] app : conflictList){
			System.out.println(Arrays.toString(app));
		}
		System.out.println("....");
		int[][] resultAppointments = new int[nonConflictList.size()][];
		nonConflictList.toArray(resultAppointments);
		return resultAppointments;
	}
	
	private static boolean isConflict(int[] src, int[] dest) {
		int srcStartTime = src[0];
		int srcEndTime = src[1];
		int destStartTime = dest[0];
		int destEndTime = dest[1];
		if(srcEndTime > destStartTime){
			return true;
		}else if(srcStartTime < destStartTime && srcEndTime > destEndTime){
			return true;
		}else{
			return false;
		}
	}

	private static void print(int[][] appointments) {
		for(int[] appointment : appointments){
			 System.out.println(Arrays.toString(appointment));
		 }
	}
	
	public static void main(String[] args) {
		 int[][] appointments = { {1, 5},{2, 6}, {2,4}, {10, 15}, {5, 6}, {4, 100}};
		 appointments = removeConflictAppoinement(appointments);
		 print(appointments);
	}

}
