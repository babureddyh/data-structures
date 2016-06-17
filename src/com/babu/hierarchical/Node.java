package com.babu.hierarchical;

public class Node {
	int data;
	Node right, left;
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return Integer.toString(data);
	}
}
