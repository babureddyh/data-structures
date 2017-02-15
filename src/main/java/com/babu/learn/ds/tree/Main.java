package com.babu.learn.ds.tree;

public class Main {

	public static void main(String[] args) {
//		BinarySearchTree bst = buildCompleteBST();
//		bst.printInorderTraversal();
		countInRange();
	}
	
	public static void secondLargest() {
		BinarySearchTree bst = buildCompleteBST();
		bst.printInorderTraversal();
		bst.secondLargest();
		
		bst = buildEmptyTree();
		bst.secondLargest();
	}
	
	public static void countInRange() {
		BinarySearchTree bst = buildCompleteBST();
		System.out.println(" In range of 3 and 5 "+ bst.countInRangeOf(5, 3));
	}
	
	public static BinarySearchTree buildEmptyTree() {
		return new BinarySearchTree();
	}
	public static BinarySearchTree buildCompleteBST() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);
		bst.insert(4);
		bst.insert(6);
		bst.insert(9);
		return bst;
	}

}
