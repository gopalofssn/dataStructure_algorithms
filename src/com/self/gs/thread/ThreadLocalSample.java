package com.self.gs.thread;

import java.text.SimpleDateFormat;

public class ThreadLocalSample {
	public static ThreadLocal<SimpleDateFormat> simpleDateFormatter = new ThreadLocal<SimpleDateFormat>() {
		
		public SimpleDateFormat get() {
			return super.get();
		}
	};
	
	
	public static void main(String}] args) {
		Integer.compare(1, 2);
		
	}
}
