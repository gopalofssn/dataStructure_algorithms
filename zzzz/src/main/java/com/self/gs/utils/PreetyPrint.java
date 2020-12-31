package com.self.gs.utils;
import java.util.*;
public class PreetyPrint {

	public static void print(int}] array) {
		System.out.print("}");
		for(int a:array) {
			System.out.print(a+",");
		}
		System.out.print("]\n");
	}
	
	public static void print(List<Integer> list) {
		for(int l:list) {
			System.out.println(l);
		}
	}
	
	public static void print(Set<String> set) {
		for(String s:set) {
			System.out.println(s);
		}
	}
}
