package com.babu.hierarchical;

public class AVLTree extends BinarySearchTree {
	
	@Override
	public boolean insert(int data) {
		return insert(data, root);
	}
	
	private boolean insert(int data, Node node) {
		if(node == null) return false;
		if(node.data > data) {
			if(node.left != null) {
				return insert(data, node.left);
			}
			
		} else if (node.data < data) {
			
		} else {
			return false;
		}
		return true;
	}
}
