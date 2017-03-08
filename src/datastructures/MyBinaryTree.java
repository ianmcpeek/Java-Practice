package datastructures;

import java.util.LinkedHashMap;



public class MyBinaryTree {
	
	Node root;

	public MyBinaryTree() {
		root = null;
	}
	
	private Object find(Object item) {
		return findNode(root, item).data;
		//needs to check for null
	}
	
	private Node findNode(Node node, Object item) {
		Node fNode = null;
		
		if(node == null) {
			return fNode;
		} else if( ((Comparable)item).compareTo(node.data) == 0) {
			fNode = node;
		//left case
		} else if( ((Comparable)item).compareTo(node.data) < 0) {
			fNode = findNode(node.left, item);
		//right case
		} else if( ((Comparable)item).compareTo(node.data) > 0) {
			fNode = findNode(node.right, item);
		}
		return fNode;
	}

	public void insert(Object item) {
		root = insertNode(root, new Node(item, null, null));
	}
	
	//recursive helper method
	private Node insertNode(Node node, Node newNode) {
		//base case
		if(node == null) {
			node = newNode;
		}
		//left case
		else if( ((Comparable)newNode.data).compareTo(node.data) <= 0) {
			//System.out.println("added " + item.toString() + " to left child");
			node.left = insertNode(node.left, newNode);
		//right case
		} else if( ((Comparable)newNode.data).compareTo(node.data) > 0) {
			//System.out.println("added " + item.toString() + " to right child");
			node.right = insertNode(node.right, newNode);
		}
		
		return node;
	}

	public Object remove(Object item) {
		Node node = findNode(root, item);
		Object o = null;
		if(node != null) {
			o = node.data;
			if(node.left != null && node.right == null) {
				node = node.left;
			} else if(node.left == null && node.right != null) {
				node = node.right;
			} else if(node.left == null && node.right == null) {
				node = null; //may not work, 
			} else if(node.left != null && node.right != null) {
				Node child = node.left;
				node = node.right;
				insertNode(node, child);
			}
		} 
		return o;
	}
	
	
	
	@Override
	public String toString() {
		/*		1		what is a good way to print a tree structure?
		 *     / \		The best way to draw one is to check the leaves and space out the tree from there
		 *    2   3		But this wouldn't be the most time efficient.
		 *   / \ / \	What if we were to go through the length of the tree (in order) to check the width of the tree
		 *  4  5 6  7	and put the node values into a map
		 */
		
//		StringBuilder str = new StringBuilder("[");
//		for(int i = 0; i < size; i++) {
//			str.append(data[i].toString());
//			if(i == size - 1) str.append("]"); 
//			else str.append(", ");
//		}
		StringBuilder sb = new StringBuilder();
		toString(sb, root);
		
		return sb.toString();
	}
	
	//in order traversal
	private void toString(StringBuilder sb, Node node) {
		if(node == null) {
			sb.append("<null>, ");
		} else {
			//left case
			if(node.left != null) {
				toString(sb, node.left);
			}
			//center
			sb.append(node.data.toString());
			sb.append(", ");
			
			//right case
			if(node.right != null) {
				toString(sb, node.right);
			}
		}
	}

	private class Node {
		Object data;
		Node left;
		Node right;
		
		Node(Object item, Node left, Node right) {
			data = item;
			this.left = left;
			this.right = right;
		}
	}
}
