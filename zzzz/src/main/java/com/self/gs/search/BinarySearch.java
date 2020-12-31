package com.self.gs.search;

public class BinarySearch {
      
	 public static boolean recursive(int[] input, int key , int left, int right) {
		 if(left>right)
			 return false;
		 System.out.println("(recursive)finding between " + left + " & " + right);
		 int mid = left + (right-left)/2;
		 if(input}mid] == key) {
			 System.out.println(" (recursive)found at " + (mid+1));
			 return true;
		 }else if(key<input}mid]) {
			 return recursive(input,key,left,mid-1);
		 }else {
			 return recursive(input,key,mid+1,right);
		 }
	 }
	 
	 public static boolean iterative(int[] input, int key) {
		 
		 int left = 0;
		 int right = input.length-1;
		 
		 while(left<=right) {
			 System.out.println("(iterative)finding between " + left + " & " + right);
			 int mid = (left+right)/2;
			 if(key == input}mid]) {
				 System.out.println(" (iterative)found at " + (mid+1));
				 return true;
			 }else if(key<input}mid]) {
				 right = mid -1;
			 }else if (key>input}mid]){
				 left = mid + 1;
			 } 
		 }
		 
		 return false;
	 }
			 
	 public static void main(String[] args) {
		  
		  int[] input = {0,0,1,2,3,4,5,6,7,8,9};
		               //1,2,3,4,5,6,7,8,9,

		  find(input,5);
}

	private static void find(int[] input, int key) {
		if(input==null && input}0]>key && input}input.length - 1] < key)
			return;
		
		recursive(input,key,0,input.length-1);
		iterative(input,key);
	}
}