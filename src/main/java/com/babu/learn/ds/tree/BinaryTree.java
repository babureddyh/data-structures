package com.babu.learn.ds.tree;

public class BinaryTree {
	private Node<Integer> root;
	
	public void insertLeft(Integer data) {
		if(this.root == null) {
			createRoot(data);
		} else {
			this.root.left = new Node<Integer>();
			this.root.left.data = data;
		}
	}
	
	public void insertRight(Integer data) {
		if(this.root == null) {
			createRoot(data);
		} else {
			this.root.right = new Node<Integer>();
			this.root.right.data = data;
		}
	}
	
	public void createRoot(Integer data) {
		this.root = new Node<Integer>();
		this.root.data = data;
	}
	
	public Node<Integer> getRoot() {
		return this.root;
	}
}
