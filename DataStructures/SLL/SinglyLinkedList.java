/* 
 * @author Dong Luu
 * @version 9/23/18
 */
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T>{
	
	private Node<T> head;		// keeps track of head of list
	private Node<T> tail;		// keeps track of tail of list
	private Node<T> current;	// keeps track of where we are in the list
	private Node<T> previous;	// keeps track of previous node
	private int size;
	
	// Constructor
	public SinglyLinkedList() {
		Node<T> head = null;
		Node<T> tail = null;
		size = 0;
	}

	/* Add the given elemen to the end of the list */
	public void add(T element) {
		Node<T> node = new Node<T>(element, null);
		current = node;
		System.out.println("Push " + element );
		if (head == null) {
			head = node;
			tail = head;
		}
		else {
			node.next = head;
			head = node;
		}
		size++;

	}
	
	/* Inserts a given element at a given index of the list.
	Counting starts with zero from the first. */
	public void insertAt(T element, int index){
		Node<T> node = new Node<T>(element, null);
		current = head;
		

		if (current != null) {
			for (int i = 0; i < index ; i++) {
				if (current.getNext() != null){
					current = current.getNext();
				}
			}
		}
		
		node.setNext(current.getNext());
		current.setNext(node);
		size++;
		System.out.println("Inserting " + element );

	}
	
	/* Remove the first occurrence of the given element from the list. */
	public void remove(T element) {
		current = head;
		previous = null;

		
		if (head.data.equals(element)) {
			head = head.next;
			System.out.println("Removing: " + element );
			return;
		}

		while(current != null && !current.data.equals(element)) {

			previous = current;
			current = current.next;


		}
		
		previous.next = current.next;
		size--;
		System.out.println("Removing: " + element + "  S: " + size);
		
		
	}
	
	/* Remove the last element of the list. */
	public T popFirst() {
		Node<T> prevHead = head;
		head = head.next;
		return prevHead.data;

	}
	
	/* Remove all elements from the list. */
	public void clear() {
		head = null;
		tail = null;
		size = 0;
		
		System.out.println("Cleared\n" + "New List:");
	}
	
	/* Return true if the list is empty, false otherwise */
	public boolean isEmpty() {
		if (head == null){
			System.out.println("List is empty");
			return true;
		}
		else {
		System.out.println("List isn't empty");
		return false;
		}
	}
	
	/* Return the number of elements currently in the list */
	public int size() {
		System.out.println("Size of list: " + size);
		return size;
	}

	/* Return the nth value from the first (count starts with zero) */
	public T getNthFromFirst(int n) {
		Node<T> node = head;
		
		for(int i = 0; i < n-1 ; i++) {
		
			if(node.next != null) {
				node = node.next;

			}

		}
		System.out.println(n + " nodes from first: " + node.getData());
		return node.getData();
	}
	
	/* Return the nth value from the last (count starts with zero) */
	public T getNthFromLast(int n) {
		Node<T> node = head;
		current = tail;
		
		for(int i = 0; i < n-1; i++) {		
			node = head;
			while (node.next != current) {			
				node = node.next;
				
			}
			current = node;						
		}
		System.out.println(n + " nodes from last: " + current.getData());
		return node.getData();
	}
	
	/* Return iterator */
	public SinglyLinkedListIterator iterator() {
		return new SinglyLinkedListIterator();
	}
	
	/* return a String representing the content of the list */
	@Override
	public String toString() {
		String value = "";
 
		if (head != null) {
			Node<T> node = head.getNext();
			while (node != null) {
				value += current.toString();
				node = node.getNext();
			}
 
		}
		return value;
	}
	
	public class SinglyLinkedListIterator implements Iterator<T> {
		public SinglyLinkedListIterator() {
			current = head;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public T next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			T temp = current.getData();
			current = current.getNext(); 
			System.out.println(temp);
			return temp;

		}
		
		public void remove() {
			throw new UnsupportedOperationException(
				"Remove operation is not supported by this iterator");
		}
	}
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.isEmpty();
		list.add(2);
		list.add(5);
		list.add(6);
		list.insertAt(7,1);
		

		
		Iterator<Integer> iter = list.iterator();
		iter.next();
		iter.next();
		iter.next();
		iter.next();

		
		list.getNthFromLast(3);
		list.getNthFromFirst(1);
		list.remove(5);
		list.size();
		list.isEmpty();
		
	}
	class Node<T> {
		
		private T data;
		private Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		public T getData() {
			return this.data;
		}
		
		public void setData(T data){
			this.data = data;		
		}
		
		public Node<T> getNext() {
			return this.next;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;		
		}
	}
	
	}

