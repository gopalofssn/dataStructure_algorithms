package com.self.gs.digits;
import java.util.*;
public class PascalTriangle {
	public List<List<Integer>> calculate(int rows){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		result.add(row);
		
		for(int i=2; i<=rows; i++) {
			row = new ArrayList<Integer>();
			row.add(1);
			
			List<Integer> previous_row = result.get(i-2);
			System.err.println(previous_row);
			for(int j=2;j<i;j++) {
				
				row.add(previous_row.get(j-2) + previous_row.get(j-1) );
			}
			row.add(1);
			result.add(row);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		System.err.println("\n\n"+new PascalTriangle().calculate(10));
	}
}
