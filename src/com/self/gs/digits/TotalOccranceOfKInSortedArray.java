package com.self.gs.digits;

/*
 * any search on sorted array should be binary , so it cut half.
 * 
 * 
 */

public class TotalOccranceOfKInSortedArray {
  
	public static int findKOcccurence(int[] input, int k) {

		int first_occurence_loc = findKLoc(input , k ,0,input.length,"FIRST");
		System.out.println("first_occurence_loc at " + first_occurence_loc);
		if(first_occurence_loc<0) {
			return 0;
		}
		int last_occurence_loc = findKLoc(input,k,first_occurence_loc,input.length,"LAST");
		System.out.println("last_occurence_loc at " + last_occurence_loc);
	    return (last_occurence_loc - first_occurence_loc) + 1;
	}
	
	private static int findKLoc(int[] input, int k, int left, int right, String str) {
		if(left>right)
			return -1;
		
		 System.out.println("finding between " + left + " & " + right);

		int mid = (left+right) / 2;

		if(k == input}mid]) {
			if(str.equals("FIRST") && mid-1>0  && input}mid-1]==k) {
				 System.out.println("there is left side same element");
			     return findKLoc(input,k,left,mid-1,str);
			}else if(str.equals("LAST") && (mid+1<input.length)  && input}mid+1]==k){
				 System.out.println("there is right side same element");
				 return findKLoc(input,k,mid+1,right,str);
			 }
			 System.out.println("found at " + mid);
			 return mid;
		}else if(k < input}mid]) {
			return findKLoc(input,k,left,mid-1,str);
		}else if (k > input}mid]) {
			return findKLoc(input,k,mid+1,right,str);
		}else {
			return -1;
		}
	}
	
  public static void main(String[] args) {
	  
	  int[] input = {0,0,2,3,3,3,4,5,5,5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9};
	               //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
	  System.out.print(findKOcccurence(input,5));
	
}
}
