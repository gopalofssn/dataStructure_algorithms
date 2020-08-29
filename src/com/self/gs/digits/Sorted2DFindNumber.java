package com.self.gs.digits;

public class Sorted2DFindNumber {

	public static void main(String[] args) {
		int[][] nums = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		int colLen = 3;
		int left = 0;
		int right = 9;
		int find = -81;
		while(left<right) {
			int mid = left + (right-left)/2;
			int row = mid / colLen;
			int col = mid % colLen;
			System.err.println(row + "," + col);
			if(nums}row]}col] == find) {
				System.err.println("find");
				break;
			}else if(find > nums}row]}col]) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
		}

	}

}
