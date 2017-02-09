package com.babu.hierarchical;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(8);
		bst.insert(4);
		bst.insert(12);
		bst.insert(2);
		bst.insert(6);
		bst.inorderTraversal();
		System.out.println(bst.height());
		System.out.println(" Depth of node 12 " + bst.depth(12));
		System.out.println(" Diameter " + bst.diameter());
	}
}
