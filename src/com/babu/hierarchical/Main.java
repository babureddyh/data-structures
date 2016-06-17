package com.babu.hierarchical;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(2);
		bst.insert(4);
		bst.insert(8);
		bst.insert(6);
		Node node = bst.search(5);
		Node node1 = bst.search(8);
		Integer i = node.data;
		node.data = node1.data;
		node1.data = i;
		
		bst.inorderTraversal();
		bst.twoNodesAreSwapped();
		bst.inorderTraversal();
	}
}
