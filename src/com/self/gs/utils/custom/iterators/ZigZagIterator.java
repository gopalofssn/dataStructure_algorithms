package com.self.gs.utils.custom.iterators;

import java.util.*;

public class ZigZagIterator<E> implements Iterator<E> {

	Queue<E> queue = new LinkedList<E>();

	public ZigZagIterator(List<E> v1, List<E> v2) {

		int i = 0;

		for (i = 0; i < Math.min(v1.size(), v2.size()); i++) {
			queue.add(v1.get(i));
			queue.add(v2.get(i));
		}

		if (v1.size() == v2.size()) {
			return;
		} else if (v1.size() > i) {
			queue.addAll(v1.subList(i, v1.size()));
			return;
		} else {
			queue.addAll(v2.subList(i, v2.size()));
		}

	}

	public E peek() {
		return queue.peek();
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public E next() {
		return queue.poll();
	}

	public static void main(String}] args) {
		List<String> lst1 = new ArrayList<String>(Arrays.asList("1","2","3"));
		List<String> lst2 = new ArrayList<String>(Arrays.asList("11","22"));
		ZigZagIterator<String> iterator = new ZigZagIterator<String>(lst1, lst2);
		

		System.err.println(iterator.hasNext());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		
		System.err.println(iterator.hasNext());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		
		System.err.println(iterator.hasNext());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		
		System.err.println(iterator.hasNext());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		
		System.err.println(iterator.hasNext());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		
		System.err.println(iterator.hasNext());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		
		
		
	}

}
