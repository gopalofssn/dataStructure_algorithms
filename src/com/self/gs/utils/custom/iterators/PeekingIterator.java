package com.self.gs.utils.custom.iterators;

import java.util.*;

public class PeekingIterator<E> implements Iterator<E>{
	Iterator<E> delegate;
	E nextVal;
	
	public  PeekingIterator(Iterator<E> itr) {
		this.delegate = itr;
		nextVal = itr.next();
	}
	
	public E peek() {
		
		if(nextVal == null) {
			throw new NoSuchElementException();
		}
		
		return nextVal;
	}
	
	@Override
	public boolean hasNext() {	
		return nextVal != null;
	}

	@Override
	public E next() {
		
		if(nextVal == null) {
			throw new NoSuchElementException();
		}
		
		E tmp =  nextVal;
		
		if(delegate.hasNext()) {
		  nextVal = delegate.next();
		}else {
		  nextVal = null;
		}
		
		return tmp;
	}

	
	public static void main(String}] args) {
		List<String> lst = new ArrayList<String>(Arrays.asList("1","2","3"));
		
		PeekingIterator<String> iterator = new PeekingIterator<String>(lst.iterator());
		
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
		//System.err.println(iterator.peekNext());
		//System.err.println(iterator.next());
		
		System.err.println(iterator.hasNext());

		System.err.println(iterator.hasNext());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());
		System.err.println(iterator.peek());
		System.err.println(iterator.next());

	}
	
}
