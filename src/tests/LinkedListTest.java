package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import datastructures.MyLinkedList;

public class LinkedListTest {
	MyLinkedList ll;
	
	@Before
	public void setUp() {
		ll = new MyLinkedList();
	}
	
	@Test
	public void testAdd() {
		assertFalse(ll.getSize() == 1);

		ll.add(new Integer(2));
		assertTrue(ll.getSize() == 1);
		assertTrue((Integer)ll.get(0) == 2);
		
		ll.add(new Integer(1));
		assertTrue(ll.getSize() == 2);
		assertTrue((Integer)ll.get(0) == 1);
		
		assertFalse(ll.getSize() == 3);
	}
	
	@Test
	public void testInsert() {
		assertFalse(ll.getSize() == 1);
		
		ll.insert(0, new Integer(1));
		assertTrue(ll.getSize() == 1);
		
		ll.insert(1, new Integer(2));
		assertTrue(ll.getSize() == 2);
		assertTrue((Integer)ll.get(1) == 2);
		
		ll.insert(2, new Integer(3));
		assertTrue(ll.getSize() == 3);
		assertTrue((Integer)ll.get(2) == 3);
	}
	
	@Test
	public void testDelete() {
		ll.add(3);
		ll.add(2);
		ll.add(1);
		
		assertTrue(ll.getSize() == 3);
		
		assertTrue((Integer)ll.remove(2) == 3);
		assertTrue(ll.getSize() == 2);
		
		assertTrue((Integer)ll.remove(1) == 2);
		assertTrue(ll.getSize() == 1);
		
		assertTrue((Integer)ll.remove(0) == 1);
		assertTrue(ll.getSize() == 0);
	}
	
	@Test
	public void testToString() {
		ll.add(3);
		ll.add(2);
		ll.add(1);
		assertTrue(ll.toString().equals("1 -> 2 -> 3"));
	}

}
