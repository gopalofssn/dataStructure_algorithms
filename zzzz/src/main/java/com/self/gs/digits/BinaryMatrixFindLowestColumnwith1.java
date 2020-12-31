package com.self.gs.digits;

public class BinaryMatrixFindLowestColumnwith1 {

	/*
	 * Time : r * log(c)
	 * Space : constant
	 */
	private static int findLeftmostIndexOfOne(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[1].length == 0) return -1;
		int leftMostColumnWithOne = -1;
		
		for(int row = 0; row < matrix.length; row++) {
			int col = matrix[row].length - 1;
			if(matrix[row][col] == 0) {
				continue;
			}
			
			int possibleLowest = binarySearch(matrix[row], 1);
			
			leftMostColumnWithOne =  (leftMostColumnWithOne != - 1)? Math.min(leftMostColumnWithOne, possibleLowest) : possibleLowest;
	
		}
			
		return leftMostColumnWithOne;
	}
	
	private static int binarySearch(int[] nums, int target) {
		if(nums == null || nums.length == 0) return -1;
		
		int left = 0;
		int right = nums.length - 1;//////////////////// --- CAREFUL
		
		int firstLowestOnePosition = -1;
		
		while(left <= right) {
			int mid = left + ( (right - left) >> 1) ;
			if(nums[mid] != 1) {
				left = mid + 1;	
			}else {
				firstLowestOnePosition = mid;
				right = mid -1;
			}
		}
		
		return firstLowestOnePosition;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0, 1 }, 
						   { 0, 0, 1, 1 }, 
						   { 0, 1, 1, 1 },
						   { 0, 0, 0, 0 } 
						   };
		test(matrix, 1);

		int[][] matrix2 = { 
				           { 0, 0, 0, 0 }, 
				           { 0, 0, 0, 0 }, 
				           { 0, 0, 0, 0 }, 
				           { 0, 0, 0, 0 } };

		test(matrix2, -1);

		int[][] matrix3 = { { 0, 0, 0, 0 }, 
						    { 0, 0, 0, 0 }, 
						    { 0, 0, 0, 0 }, 
						    { 0, 0, 0, 1 } };

		test(matrix3, 3);
	}

	private static void test(int[][] matrix, int expected) {
		int actual = findLeftmostIndexOfOne(matrix);
		if (actual == expected) {
			System.out.println("PASSED!");
		} else {
			System.out.println(String.format("FAILED! Expected: %d, but got: %d", expected, actual));
		}
	}

	

}
