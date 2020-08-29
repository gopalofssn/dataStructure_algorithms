package com.self.gs.learn.util;
import java.util.*;
public class BitSetMain {
  public static void main(String[] args) {
	BitSet bitset = new BitSet();
	bitset.set(1);
	bitset.set(2);
	bitset.set(3);
	bitset.set(4);
	System.err.println(bitset.cardinality());
	
	BitSet bitset2 = new BitSet();
	bitset2.set(1);
	bitset2.set(2);
	bitset2.set(3);
	bitset2.set(7);
	System.err.println(bitset2);
	
	bitset2.andNot(bitset);
	System.err.println(bitset2.toString());
	
	
}
}
