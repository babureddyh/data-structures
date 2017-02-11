package com.babu.learn.ds.tree;

import java.util.Optional;

public class BinarySearchTree {
	private Node<Integer> root;
	
	public boolean insert(Integer data) {
		if(data == null) {
			return false;
		}
		if(this.root == null) {
			this.root = new Node<Integer>();
			this.root.data = data;
		} else {
			return add(data, root);
		}
		return true;
	}
	
	// Don't call with null value
	private boolean add(Integer data, Node<Integer> node) {
		if(node.data < data) {
			if(node.right == null) {
				node.right = new Node<Integer>();
				node.right.data = data;
			} else {
				return add(data, node.right);
			}
		} else if (node.data > data) {
			if(node.left == null) {
				node.left = new Node<Integer>();
				node.left.data = data;
			} else {
				return add(data, node.left);
			}
		} else {
			return false;
		}
		return true;
	}
	
	public void printInorderTraversal() {
		if(this.root == null ) {
			System.err.println("Error: Empty tree");
		} else {
			inorderTraversal(this.root);
		}
	}
	
	// Don't pass null value.
	private void inorderTraversal(Node<Integer> node) {
		if(node != null) {
			inorderTraversal(node.left);
			System.out.println(node.data+" ");
			inorderTraversal(node.right);
		}
	}
	
	public void secondLargest() {
		if(this.root == null) {
			System.out.println(" Empty root ");
			return;
		}
		int total = secondLargest(this.root, 0);
		System.out.println(" Number of nodes "+ total);
	}
	
	private int secondLargest(Node<Integer> node, int count) {
		int count1;
		if(node != null) {
			// First logic should be just a recursive call
			count1 = secondLargest(node.right, count);
			
			////////// All main logic 
			count1++;
			if(count1+count == 2) {
				System.out.println(" Second largest in the tree "+node.data);
			}
			///////////////// End of main logc
			
			// Last logic should be just a recursive call. Just passing the results from main area
			count1 = secondLargest(node.left, count1);
			
			return count1;
		}
		//Corner case handling
		return count;
	}
	
	public Optional<Node<Integer>> min() {
		if(this.root != null) {
			return Optional.of(this.min(this.root));
		}
		return Optional.empty();
	}
	
	public Node<Integer> min(Node<Integer> node) {
		return (node.left != null)?min(node.left):node;
	}
	
	public Optional<Node<Integer>> max() {
		if(this.root != null) {
			return Optional.of(this.max(this.root));
		}
		return Optional.empty();

	}
	
	public Node<Integer> max(Node<Integer> node) {
		return (node.right != null)?node:max(node.right);
	}
	
}
