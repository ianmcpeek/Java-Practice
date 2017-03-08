package datastructures;

import java.util.Iterator;

/**
 * MyArrayList
 * 
 * This is an implementation of an array that automatically resizes to
 * accommodate an unspecified quantity of objects.
 * 
 * TODO:
 * 	-Shrink arraylist on remove, can't go beneath STATIC MINSIZE;
 *  -add in an insert method //DONE
 *  -use throwables to print errors on bad behavior
 * 
 * @author Ian McPeek
 * @since March 30, 2016
 */
public class MyArrayList implements MyDataStructures, Iterable<Object> {

	private int capacity;
	private int size;
	private Object[] data;
	
	public MyArrayList() {
		this(10);
	}
	
	public MyArrayList(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.data = new Object[capacity];
	}
	
	private boolean isValidIndex(int index) {
		return index >= 0 && index < size;
	}

	public int indexOf(Object o) {
		int index = -1;
		for(int i = 0; i < size; i++) {
			if(data[i].equals(o)) {
				index = i; break;
			}
		}
		return index;
	}
	
	public Object get(int index) {
		if(isValidIndex(index)) return null;
		return data[index];	
	}
	
	public void insert(int index, Object item) {
		Object orphan = get(index);
		data[index] = item;
		size++;
		for(int i = index + 1; i < size; i++) { 
			//after item has been inserted, all other items must be shifted to accommodate the new item
			Object temp = data[i];
			data[i] = orphan;
			orphan = temp;
		}
		data[size] = orphan;
		if(size == capacity) {
			//resize if neccessary
			//double if full
			System.out.println("ArrayList Full, resizing!");
			resize(capacity*2);
		}
	}
	
	public void add(Object item) {
		data[size] = item;
		size++;
		if(size == capacity) {
			//resize if neccessary
			//double if full
			System.out.println("ArrayList Full, resizing!");
			resize(capacity*2);
		}
	}
	
	public Object remove(int index) {
		//shrink if quarter full
		Object o = null;
		o = get(index);
		if(o != null) {
//			//Lazy Man's Remove
//			//For simple purposes I am swapping the last item in the array with the index being removed
//			//swap index and last element
//			data[index] = data[size-1];
//			size--;
			
			//Full Shift Remove
			//proper use of remove in an arraylist will shift all values to the right
			for(int i = index; i < size - 1; i++) {
				data[i] = data[i+1];
			}
			size--;
		}
		return o;
	}
	
	private void resize(int newCapacity) {
		Object[] array = new Object[newCapacity];
		for(int i = 0; i < size; i++) {
			array[i] = data[i]; 
			//TODO:  very important, works only for primitives
			//needs to implement defensive copying
		}
		data = array;
		capacity = newCapacity;
	}

	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for(int i = 0; i < size; i++) {
			str.append(data[i].toString());
			if(i == size - 1) str.append("]"); 
			else str.append(", ");
		}
		return str.toString();
	}

	@Override
	public Iterator<Object> iterator() {
		return new MyIterator();
	}
	
	public class MyIterator implements Iterator<Object>{
		int index = 0;

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public Object next() {
			Object o = data[index];
			index++;
			return o;
		}

		}
	
}