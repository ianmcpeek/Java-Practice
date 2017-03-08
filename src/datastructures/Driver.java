package datastructures;

import java.util.Arrays;

public class Driver {
	//TODO: add O(n) for all operations in all data structures

	public static void main(String[] args) {
		
		/*ARRAYLIST BEGIN*/
		System.out.println("ArrayList && SortedArrayList");
	
		MyArrayList alist = new MyArrayList();
		System.out.println("adding 1 ... 20");
		int i = 1;
		while(i < 21) {
			alist.add(i); i++;
		}
		System.out.println(alist.toString()); 
		System.out.println("Number should be 13: " + alist.get(12).toString());
		alist.remove(12);
		System.out.println("Removed 13. Number should be 14: " + alist.get(12).toString());
		alist.remove(19);
		System.out.println("20 should still exist: " + alist.toString());
		alist.remove(18);
		System.out.println("19 should now be missing: " + alist.toString());
		alist.insert(0, 404);
		alist.insert(alist.getSize(), 404);
		System.out.println(alist.toString());
		/*ARRAYLIST END*/
		
		System.out.println("\n\nLinkedList && SortedLinkedList");
		MyLinkedList llist = new MyLinkedList();
		i = 1;
		while(i < 21) {
			llist.add(i); i++;
		}
		System.out.println("Should be 17: " + llist.get(16));
		System.out.println(llist.toString());
		System.out.println("Removing 20: " + llist.remove(19));
		System.out.println(llist.toString());
		System.out.println("Removing 1: " + llist.remove(0));
		System.out.println(llist.toString());
		System.out.println("Removing 17: " + llist.remove(15));
		System.out.println("Removing 24: " + llist.remove(23));
		System.out.println(llist.toString());
		llist.add(20);
		System.out.println("Adding 20");
		System.out.println(llist.toString());
		
		System.out.println("42 should be at front of LinkedList");
		llist.insert(0, 42);
		System.out.println(llist.toString());
		
		System.out.println("43 should be third element of LinkedList");
		llist.insert(2, 43);
		System.out.println(llist.toString());
		
		System.out.println("44 should be at end of LinkedList");
		llist.insert(llist.getSize(), 44);
		System.out.println(llist.toString());
		
		//TODO: test linked list of LinkedLists
//		
//		System.out.println("Stack && Queue && Heap");
//		
//		System.out.println("BinaryTree && AVL Tree && Red/Black Tree && SplayTree");
		MyBinaryTree btree = new MyBinaryTree();
		btree.insert(4);
		btree.insert(2);
		btree.insert(6);
		btree.insert(1);
		btree.insert(3);
		btree.insert(5);
		btree.insert(7);
		System.out.println(btree.toString());
		btree.remove(2);
		System.out.println(btree.toString());
//		
//		System.out.println("HashTable && HashMap");
//		
//		System.out.println("UndirectedGraph && DirectedGraph");
//		
//		System.out.println("Huffman Coding");
//		
//		System.out.println("Dijkstra vs BreadthFirst vs Depthfirst");	
		
	}
}
