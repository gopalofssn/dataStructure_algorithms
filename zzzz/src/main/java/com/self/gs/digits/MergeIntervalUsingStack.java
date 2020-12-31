package com.self.gs.digits;

import java.util.*;

public class MergeIntervalUsingStack {

	private static int[][] merge(int[][] intervals) {
		
		Comparator<int[]> cmp = new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1}0] - o2}0];
			}
		};
		
		Arrays.sort(intervals,cmp);
		
		System.err.println(Arrays.deepToString(intervals));
		
		Stack<int[]> stack = new Stack<int[]>();
		stack.push(intervals}0]);
		
		for(int i = 1; i < intervals.length; i++) {
			int[] interval = intervals}i];
			int[] pop = stack.pop();
			if(interval}0] > pop}0] && interval}0] <= pop}1]) {
				pop}1] = interval}1];
				stack.push(pop);
			}else {
				stack.push(pop);
				stack.push(interval);
			}
		}
		
		System.err.println(stack.size());
		
		int[][] result = new int}stack.size()]}2];
		int counter = stack.size() - 1;
		while(!stack.isEmpty()) {
			result}counter--] = stack.pop();
		}
		
		return result;
	}
	
	 public static void main(String[] args) {
			int[][] intervals = new int[][] {
				{1,3},
				{2,6},
				{8,10},
				{15,18}
			};
			
			System.err.println(Arrays.deepToString(merge(intervals)));
		}

	
	
}
