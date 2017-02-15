package com.babu.learn.ds.tree;

public class Main {

	public static void main(String[] args) {
//		BinarySearchTree bst = buildCompleteBST();
//		bst.printInorderTraversal();
//		countInRange();
		transformGreaterSumTree();
	}
	
	public static void transformGreaterSumTree() {
		BinarySearchTree bst = buildCompleteBST();
		bst.transformToGreatestSumTree();
		bst.printInorderTraversal();
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
		System.out.println(" In range of 3 and 5 "+ bst.countSubTreesInRangeOf(5, 45));
	}
	
	public static BinarySearchTree buildEmptyTree() {
		return new BinarySearchTree();
	}
	public static BinarySearchTree buildCompleteBST() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(50);
		bst.insert(1);
		bst.insert(40);
		bst.insert(100);

		return bst;
	}

}
