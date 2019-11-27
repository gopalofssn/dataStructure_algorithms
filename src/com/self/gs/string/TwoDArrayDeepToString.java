package com.self.gs.string;

import java.util.Arrays;

public class TwoDArrayDeepToString {

	public static void main(String[] args) {
		String data[][][] = new String[][][] {
		   {
			{"00","01","02"},
			{"00","01","02"},
			{"00","01","02"}
		  },
		   {
				{"10","01","02"},
				{"10","01","02"},
				{"10","01","02"}
			  }
		};
		System.err.println(Arrays.deepToString(data));
	}

}
