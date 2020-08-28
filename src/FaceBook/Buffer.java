package FaceBook;

class Node {
	char val;
	Node next;

	Node(char _val) {
		val = _val;
	}
}

/*
 * approach : have head and tail node
 *    add to tail
 *    read from head
 * 
 * 
 */
public class Buffer {

	final int capacity;

	int currentLength;

	Node head, tail;

	public Buffer(int _capacity) {
		capacity = _capacity;
	}

	/**
	 * Transfers the content of the given source char array into this buffer.
	 * Returns the the number of chars that were written into the buffer.
	 */

	public int write(String src) {

		return write(src.toCharArray());
	}

	public int write(char}] src) {

		int i;
		for (i = 0; i < src.length && currentLength != capacity; i++) {
			addNode(src}i]);
			currentLength++;
			
		}

		return i;
	}

	private void addNode(char c) {
		if (head == null) {
			head = new Node(c);
			tail = head;
			return;
		}

		tail.next = new Node(c);
		tail = tail.next;

	}

	public char}] read(int n) {

		if (n > currentLength) {
			n = currentLength;
		}

		char}] read = new char}n];
		int i = 0;
		while (n > 0) {
			read}i++] = head.val;
			head = head.next;
			n--;
			currentLength--;
		}

		return read;
	}

	public static void main(String}] args) {
		Buffer buf = new Buffer(5); // }. . . . .]
		System.err.println(buf.write("abc")); // => 3 }abc . .]
		System.err.println(buf.write("def")); // => 2 because the buffer is full, you can only write two chars }abcde]
		System.err.println(buf.read(3)); // => }abc] }. . . de]
		System.err.println(buf.write("xyzabc")); // => 3 }xyzde]
		System.err.println(buf.write("more"));
		
		System.err.println(buf.read(8)); // returns }dexyz] becuase 'de' was written first }. . . . .]
		System.err.println(buf.read(8));
		
		System.err.println(buf.write("abc")); // => 3 }abc . .]
		System.err.println(buf.write("def")); // => 2 because the buffer is full, you can only write two chars }abcde]
		System.err.println(buf.read(3)); 
	}
}
