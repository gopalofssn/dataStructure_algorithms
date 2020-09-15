package com.self.gs.utils.custom.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class SortedIteratorOnUnSortedLists<T> {

	PriorityQueue<T> minHeap = new PriorityQueue<T>();
	
	@SafeVarargs
	public SortedIteratorOnUnSortedLists(List<T>... unsortedLists ){
		if(unsortedLists == null || unsortedLists.length == 0) {
			throw new IllegalArgumentException("Unsorted lists can not be null or empty !");
		}	
		for(List<T> lst : unsortedLists) {
			for(T element : lst) {
				minHeap.add(element);
			}
		}	
	}
	
	public T next() {
		if(hasNext()) {
			return minHeap.poll();
		}	
		throw new NoSuchElementException();
	}
	
	public boolean hasNext() {
		return ! minHeap.isEmpty();
	}

	public static void main(String... args) {
		List[] array = new ArrayList[3];
		array[0] = new ArrayList<Integer>(Arrays.asList(5, 1, 2, 4));
		array[1]  = new ArrayList<Integer>(Arrays.asList(4, 6, 3));
		array[2] = new ArrayList<Integer>(Arrays.asList(9, 0, 7));
		SortedIteratorOnUnSortedLists<Integer> itr = new SortedIteratorOnUnSortedLists<Integer>(array);
		while(itr.hasNext()) {
			System.err.println(itr.next());
		}
	}

}
