package com.gs.numbers.missing;

public class FindMissingNumber {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 5, 6};
		System.out.println("missing num findWithCalculation - " + findWithCalculation(nums, 6));
		System.out.println("missing num findWithBinarySearch - " + findWithBinarySearch(nums, 6));
		System.out.println("missing num findWithXOR - " + findWithXOR(nums, 6));
	}

	private static int findWithXOR(int[] nums, int n) {
		if(nums[0] != 1) return 1;
		if(nums[nums.length -1 ] != n) return n;
		
		int val = 0;
		int index = 0;
		while(index < n) {
			int expectedValue = (index + 1);
			val = val ^ nums[index];
			System.out.println("val " + val);
			if(val != expectedValue ) {
				return index;
			}
			index++;
		}
		return val;
	}

	/* approach 1
	 n(n+1)/2 = total [1...n]
	*/
	private static int findWithCalculation(int[] nums, int n) {
		int sum =  ((n)*(n + 1)) / 2; // integer overflow
		for(int num : nums) {
			sum -= num;  // O(n) time
		}
		return sum;
	}

	// Binary search o(log n)
	private static int findWithBinarySearch(int[] nums, int totalNumbers) {
		 
		 if(nums[0] != 1) return 1;
		 if(nums[nums.length -1 ] != totalNumbers) return totalNumbers;
		 
		 int left = 0;
		 int right = totalNumbers;
		 
		 while(left < right) {
			 int mid = left + ((right - left) / 2); 
			 int expectedValueAtMid = mid + 1;
			 
			 if(nums[mid] != expectedValueAtMid) { 
				 int prevValue = nums[mid -1];
				 if(prevValue != expectedValueAtMid) {
					 return expectedValueAtMid;
				 }
				 right = mid;
			 }else {
				 left = mid;
			 }
			 
		 }
		 
		 return -1;
	}
}
