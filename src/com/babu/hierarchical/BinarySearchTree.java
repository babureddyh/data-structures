package com.babu.hierarchical;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	private Node root;
	
	public boolean insert(int data) {
		if(root == null) {
			root = new Node(data);
		}else {
			Node temp = root;
			while(true) {
				if(temp.data == data){
					return false;
				}
				if(temp.data < data) {
					if(temp.right == null) {
						temp.right = new Node(data);
						return true;
					}else {
						temp = temp.right;
					}
				} else {
					if(temp.left == null) {
						temp.left = new Node(data);
						return true;
					}else {
						temp = temp.left;
					}
				}
			}
		}
		return false;
	}
	
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node node) {
		if(node == null) return;
		inorderTraversal(node.left);
		System.out.print(node.data+" ");
		inorderTraversal(node.right);
	}
	
	public Node search(int key) {
		return searchRecursive(key, root);
	}
	
	private Node searchRecursive(int key, Node node) {
		if(node == null) return null;
		if(node.data == key) return node;
		if(node.data > key) return searchRecursive(key, node.left);
		else return searchRecursive(key, node.right);
	}
	
	public boolean delete(int key) {
		Node temp = root;
		Node parent = null;
		boolean isSuccess = false;
		while(temp != null) {
			if(temp.data == key) {
				isSuccess = true;
				break;
			}
			else if(temp.data > key) {
				parent = temp;
				temp = temp.left;
			}else {
				parent = temp;
				temp = temp.right;
			}
		}
//		System.out.println(" -- " + temp.toString() + " " +parent);
		if(!isSuccess) {
			System.out.println("Key doesn't exist in the tree");
			return false;
		}
		
		// have two child nodes
		if(temp.left != null && temp.right != null) {
			/// find in-order successor i.e left most leaf of right node.
			Node inorderSuccesoor = temp.right, itsParent = temp;
			while(inorderSuccesoor.left != null) {
				itsParent = inorderSuccesoor;
				inorderSuccesoor = inorderSuccesoor.left;
			}
			
			temp.data = inorderSuccesoor.data;
			if(itsParent != temp)itsParent.left = null;
			else itsParent.right = null;
		} 
		// have only one child
		else if(temp.left != null || temp.right != null) {
			if(parent == null) {
				if(temp.left != null) {
					root = temp.left;
				}else{
					root = temp.right;
				}
			}else if(parent.left == temp) {
				if(temp.left != null) {
					parent.left = temp.left;
				}else{
					parent.left = temp.right;
				}
			}else {
				if(temp.left != null) {
					parent.right = temp.left;
				}else{
					parent.right = temp.right;
				}
			}
		}
		// have no child
		else {
			if (parent == null) {
				root = null;
			}else{
//				System.out.println(parent.toString() + temp);
				if(parent.left == temp) parent.left = null;
				else parent.right = null;
			}
		}
		return isSuccess;
	}
	public Node minimum() {
		return minimumItr(root);
	}
	
	public Node minimumItr(Node root) {
		if(root == null) return null;
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}

	public Node maximumItr(){
		if(root == null) return null;
		Node temp = root;
		while(temp.right != null){
			temp = temp.right;
		}
		return temp;
	}
	
	public void twoNodesAreSwapped() {
		List<Integer> list = new ArrayList<>();
		inorderFillList(list, root);
		int data1 = -1, data2 = -1;
		// find if first element is one of them
		for(int i=0; i < list.size()-1; i++) {
			if(list.get(i) > list.get(i+1)) {
				if(data1 == -1) {
					data2 = i;
					break;
				}else {
					data1 = i;
				}
			}
		}
		if(data2 == -1) data2 = data1+1;
		
		Node node = this.search(list.get(data1));
		Node node1 = this.search(list.get(data2));
		Integer i = node.data;
		node.data = node1.data;
		node1.data = i;
		
	}
	
	private void inorderFillList(List<Integer> list, Node currentNode) {
		if(currentNode == null)return;
		inorderFillList(list, currentNode.left);
		list.add(currentNode.data);
		inorderFillList(list, currentNode.right);
	}
}