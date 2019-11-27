package com.self.gs.utils;
import java.util.*;
public class ShiftOprator {
public static void main(String[] args) {
	short val = (short)(1<<('3'-'1'));
	System.err.println((short)(1<<('1'-'1'))); //1<<0 = 00000000 
	System.err.println((short)(1<<('2'-'1')));
	System.err.println((short)(1<<(3-1))); // why 8?
	System.err.println((short)(1<<('4'-'1')));
	System.err.println((short)(1<<('5'-'1')));
	System.err.println((short)(1<<('6'-'1')));
	System.err.println((short)(1<<('7'-'1')));
	System.err.println((short)(1<<('8'-'1')));
	System.err.println((short)(1<<('9'-'1')));
	
	Set<String> seen = new HashSet<String>();
	seen.add("a");
	
}
}
