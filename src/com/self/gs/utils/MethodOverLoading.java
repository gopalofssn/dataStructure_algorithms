package com.self.gs.utils;

public class MethodOverLoading {

	public static boolean isvalid(Object obj) {
		System.err.println("in obj");
		if(obj==null)
			return false;
		else
			return true;
			
	}
	
	public static boolean isvalid(String str) {
		System.err.println("in str");
		if(null==str || str.trim().equals(""))
			return false;
		else
			return true;
			
	}
	
	
	public static void main(String}] args) {
		MethodOverLoading m = null;
		System.err.println(isvalid(m));

		System.err.println(String.valueOf(new char}] {'a','b','e','f','o'},3,2));
	}

}
