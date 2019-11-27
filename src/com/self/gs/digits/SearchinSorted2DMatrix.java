package com.self.gs.digits;

// treat both side sorted array as 1D array
// apply binary search
// locate row , use / by == so give rounded  val
// locate column , use % gives mod value
public class SearchinSorted2DMatrix {
	
	// option one O(logn) , last element in current row< first element in next row , so treat like 1D array and Binary search
	public static boolean find(int[][] input, int key) {
		int rowLen = input.length; // 3
		int colLen = input[0].length; // 4
		int right = rowLen*colLen -1 ; // total(3*4) ,, 0... 11
		int left = 0;
		
		while(left<=right) {
			int mid = (left+right)/2; // 11/2 = 5
			int r = mid/colLen; // 5/4 = 1th row
			int c = mid%colLen; // 5%4 = 1st col
			if(input[r][c]==key)
				return true;
			else if(key < input[r][c]) {
				right = mid-1;
			}else {
				left = mid + 1;
			}
			System.out.println(input[r][c]);
			
		}
		
		return false;
	}
	
	
	public static boolean find1Recurssive(int[][] nums,int target) {
		
		if(nums==null || nums.length<1)
			throw new IllegalArgumentException("Input 2D array is either null or empty !!!");
		
		int length = (nums.length)*(nums[0].length);
		return binarySearchRecurssive(nums,0,length-1,target);
	}

	
	
	private static boolean binarySearchRecurssive(int[][] nums, int start, int end, int target) {
		if(start>end)
			return false;
		int mid = (start+end)/2;
		int row = (mid)/(nums.length);
		int col = (mid)%(nums[0].length);
		System.out.println("("+row+","+col+")");
		if(nums[row][col]==target)
			return true;
		else if(target<nums[row][col])
			return binarySearchRecurssive(nums,start,mid-1,target);
		else
			return binarySearchRecurssive(nums,mid+1,end,target);
	}


	//option 2 O(m+n), , last element in current row!< first element in next row
	public static boolean find2(int[][] input, int target) {
		int rowLen = input.length;
		int colLen = input[0].length;
		int r = rowLen -1;
		int c = 0;
		while(r>=0 && c<colLen) {
			if(input[r][c]==target) {
				return true;
			}else if(input[r][c]<target) {
				c++;
			}else {
				r--;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
	 int[][] input = new int[][] {
		 {1,   3,  5},
		 {10, 11, 16},
		 {23, 30, 34}
	 };
	 System.out.println(find(input,50));
	 System.out.println(find2(input,5));
	 System.out.println(find1Recurssive(input,16));
	}
}
