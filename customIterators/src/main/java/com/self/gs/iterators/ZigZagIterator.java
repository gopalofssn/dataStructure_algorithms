package com.self.gs.iterators;

import java.util.*;

public class ZigZagIterator<T> implements Iterator<T> {

	Iterator<T> iterator1;
	Iterator<T> iterator2;
	boolean flag;
	public ZigZagIterator(List<T> v1, List<T> v2) {
		iterator1 = v1.iterator();
		iterator2 = v2.iterator();
		flag = true;
	}

	@Override
	public boolean hasNext() {
		return iterator1.hasNext() || iterator2.hasNext();
	}

	@Override
	public T next() {
		if(flag){
			flag = !flag;
			return iterator1.hasNext()? iterator1.next() : iterator2.next();
		}else{
			flag = !flag;
			return iterator2.hasNext() ? iterator2.next() : iterator1.next();
		}
	}
	
	public static void main(String[] args) {
		List<String> lst1 = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		List<String> lst2 = new ArrayList<String>(Arrays.asList("11", "22"));
		ZigZagIterator<String> iterator = new ZigZagIterator<String>(lst1, lst2);
		while(iterator.hasNext()){
			System.out.println(iterator.next()); // 1 11 2 22 3 4 5
		}
	}
	
}
