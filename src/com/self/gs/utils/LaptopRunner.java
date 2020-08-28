package com.self.gs.utils;

import java.util.*;

public class LaptopRunner {
	public static void main(String}] args) {
		SortedSet<Laptop> list = new TreeSet<Laptop>();
		list.add(new Laptop(800,12,"Dell"));
		list.add(new Laptop(1200,8,"Apple"));
		list.add(new Laptop(700,16,"Hp"));
		
		Comparator<Laptop> comparator = new Comparator<Laptop>() {
			public int compare(Laptop l1, Laptop l2) {
				if(l1.getRam()>l2.getRam())
					return Integer.MAX_VALUE;
				else if(l1.getRam()<l2.getRam())
					return Integer.MIN_VALUE;
				else 
				   return 0;
			}
		};
		
		//Collections.sort(list,comparator);
		System.err.println(list);
	}
}
