package co.uk.authenticirish.testproject.algo;

import android.util.Log;

public class Algo {
	
	private static final String TAG = null;

	public Algo() {
		
	}
	
	public void init() {
		bitshifting();
	}

	private void bitshifting() {
		// 128 64 32 16 8 4 2 1
		//   0  0  0  0 0 1 0 0 = 4
		//   0  0  0  0 1 0 0 0 = 8
		//   0  0  0  0 1 1 1 1 = 15
		
		int value = 4;
		int result = 0;
		
		result = value << 1;
		
		assert(result == 8);
		Log.i(TAG, String.format("bitshifting = %d", result));
		
		result = value << 2;
		
		assert(result == 16);
		Log.i(TAG, String.format("bitshifting = %d", result));
		
		
		build123();
		
	}
	
	/** http://cslibrary.stanford.edu/110/BinaryTrees.html **/
	
	private class Node {
		private int data;
		private Node left;
		private Node right;
	}
	
	private Node newNode(int value) {
		Node node = new Node();
		node.data = value;
		node.left = null;
		node.right = null;
		return node;
	}
	
	// 	  2
	//	1	3
	private void build123() {
		Node root = newNode(2);
		root.left = newNode(1);
		root.right = newNode(3);
		
		Node root2 = insert(null, 2);
		insert(root2, 3);
		insert(root2, 1);
		
		int count = size(root);
		
	}
	
	/* 
	 Give a binary search tree and a number, inserts a new node 
	 with the given number in the correct place in the tree. 
	 Returns the new root pointer which the caller should 
	 then use (the standard trick to avoid using reference 
	 parameters). 
	*/
	private Node insert(Node node, int value) {
		if(node == null) {
			return newNode(value);
		} else {
			if(value <= node.data) {
				node.left = insert(node.left, value);
			} else {
				node.right = insert(node.right, value);
			}
			return node;
		}
	}
	
	private int size(Node node) { 
		if(node == null) {
			return 0;
		} else {
			return 1 + size(node.right) + size(node.left);
		}
	}
	
	private int maxDepth(Node node) {
		if(node == null) {
			return 0;
		} else {
			int rightDepth = maxDepth(node.right);
			int leftDepth = maxDepth(node.left);
			
			return 1 + Math.max(rightDepth, leftDepth);
		}
	}
}
