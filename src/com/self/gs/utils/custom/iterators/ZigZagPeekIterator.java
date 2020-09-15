package com.self.gs.utils.custom.iterators;

import java.util.*;

public class ZigZagPeekIterator<T> implements Iterator<T> {

	Iterator<T> iterator1;
	Iterator<T> iterator2;
	boolean flag;
	T peek;
	
	public ZigZagPeekIterator(List<T> v1, List<T> v2) {
		iterator1 = v1.iterator();
		iterator2 = v2.iterator();
		peek = iterator1.next();
		flag = false;
	}

	@Override
	public boolean hasNext() {
		return peek != null;
	}

	@Override
	public T next() {
		T next = peek;
		if(flag){
			flag = !flag;
			peek = iterator1.hasNext()? iterator1.next() : 
				     iterator2.hasNext() ? iterator2.next() : null;
		}else{
			flag = !flag;
			peek = iterator2.hasNext() ? iterator2.next() : 
				          iterator1.hasNext()? iterator1.next() : null;
		}
		return next;
	}
	
	public T peek(){
		return peek;
	}
	
	public static void main(String[] args) {
		List<String> lst1 = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		List<String> lst2 = new ArrayList<String>(Arrays.asList("11", "22"));
		ZigZagPeekIterator<String> iterator = new ZigZagPeekIterator<String>(lst1, lst2);
		while(iterator.hasNext()){
			System.out.println("peek " + iterator.peek());
			System.out.println("next " + iterator.next()); // 1 11 2 22 3 4 5
		}
	}
	
}
