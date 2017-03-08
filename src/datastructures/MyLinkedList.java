package datastructures;

public class MyLinkedList implements MyDataStructures {
	private Node head;
	private int size;
	
	public MyLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	private boolean isValidIndex(int index) {
		return index >= 0 && index < size;
	}

	@Override
	public Object get(int index) {
		if( !isValidIndex(index)) return null;
		Node current = head;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	@Override
	public void add(Object item) {
		if(size == 0) {
			head = new Node(item, null);
		} else {
			Node newHead = new Node(item, head);
			head = newHead;
		}
		size++;
	}

	@Override
	public Object remove(int index) {
		if(!isValidIndex(index)) return null;
		Node current = head;
		if(index == 0 ) {
			head = current.next;
		} else {
			Node previous = null;
			for(int i = 0; i < index; i++) {
				previous = current; 
				current = current.next;
			}
			previous.next = current.next; 
		}
		size--;
		return current.data;
	}

	@Override
	public void insert(int index, Object item) {
		if(index < 0 || index > size) return;
		Node current = head;
		Node newNode = new Node(item, null);
		if(index == 0 ) {
			newNode.next = current;
			head = newNode;
		} else {
			Node previous = null;
			for(int i = 0; i < index; i++) {
				previous = current;
				current = current.next;
			}
			newNode.next = current;
			previous.next = newNode; 
		}
		size++;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		Node current = head;
		int i =  0;
		while(current != null) {
			str.append(current.data.toString());
			if(i < size - 1) str.append(" -> ");
			current = current.next; i++;
		}
		return str.toString();
	}
	
	private class Node {
		private Object data;
		private Node next;
		
		public Node(Object data, Node node) {
			this.data = data;
			this.next = node;
		}
	}
	
	//TODO add Iterator
}
