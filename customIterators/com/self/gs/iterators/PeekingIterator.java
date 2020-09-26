package com.self.gs.iterators;

import java.util.*;

public class PeekingIterator implements Iterator<String>{
	 
	private Iterator<String> iterator;
	private String peek;
	public PeekingIterator(List<String> list) {
		if(list == null || list.isEmpty()) throw new IllegalArgumentException();
		this.iterator = list.iterator();
		this.peek = iterator.next();
	}

	private String peek() {
		if(peek == null) throw new NoSuchElementException();
		return peek;
	}
	
	@Override
	public boolean hasNext() {
		return peek != null;
	}

	@Override
	public String next() {
		String next = peek;
		if(next == null) throw new NoSuchElementException();
		peek = iterator.hasNext() ? iterator.next() : null;
		return next;
	}
	
	
	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>(Arrays.asList("1","2","3"));
		
		PeekingIterator iterator = new PeekingIterator(lst);
		
		System.err.println(iterator.hasNext()); // t
		System.err.println(iterator.peek()); // 1
		System.err.println(iterator.next()); // 1
		System.err.println(iterator.peek()); // 2
		System.err.println(iterator.next()); // 2
		
		System.err.println(iterator.hasNext()); // t
		System.err.println(iterator.peek()); // 3
		System.err.println(iterator.hasNext()); // t
		System.err.println(iterator.next()); // 3
		//System.err.println(iterator.peek()); // error
		//System.err.println(iterator.next()); // error
	}
}
