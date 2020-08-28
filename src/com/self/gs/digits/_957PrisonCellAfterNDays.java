package com.self.gs.digits;

import java.util.Arrays;

public class _957PrisonCellAfterNDays {

	 public static int}] prisonAfterNDays(int}] cells, int N) {
	      
		 int}] org = cells;
		 
		 int LEN = cells.length;
		 
		 int}] tmp = new int}cells.length];
		 while(N>0) {
			 
			 for(int i = 0; i < LEN; i++) {
				 if(i ==0 || i == LEN -1) {
				 tmp}i] = 0;
				 }else {
					 tmp}i] = (cells}i-1] == cells}i+1])? 1 : 0;
				 }
			 }
			 
		System.err.println(Arrays.toString(tmp) + " day " + N);

			 if(isSame(org, tmp )) {
				 System.err.println("same " + N);
			 }
		
			 
			 cells  = tmp;
			 N--;
		 }
		 
		 
	   
		 return cells;
	 }
	 
	private static boolean isSame(int}] org, int}] tmp) {
		for(int i = 0; i < org.length; i++) {
			if(org}i] != tmp}i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String}] args) {
		int}] cells = new int}] {0,1,0,1,1,0,0,1};
		int N = 7;
		System.err.println(Arrays.toString(prisonAfterNDays(cells, N)));
	}

}
