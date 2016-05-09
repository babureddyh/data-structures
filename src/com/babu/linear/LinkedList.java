package com.babu.linear;

public class LinkedList<T extends Comparable<T>> {
	
	public Node head;

	protected class Node {
		T data;
		Node next;
		
		public Node(T data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		public Node(T data) {
			super();
			this.data = data;
		}
	}
	
	public void push(T data) {
		Node newNode = new Node(data, head);
		head = newNode;
	}
	
	public void printList(Node temp) {
		if(temp ==null) temp = head;
		while(temp != null){
			System.out.println(temp.data+" ");
			temp = temp.next;
		}
		
		System.out.println();
	}

	//////////////////// Insertion //////////////////////

	public boolean insertAfter(int radix, T data) {
		Node temp = head;
		
		while(radix--!=1) {
			try{
				temp = temp.next;
			}catch(NullPointerException ex) {
				return false;
			}
		}
		if(temp ==null) return false;
		else {
			insertAfter(temp, data);
		}
		return true;
	}
	
	
	public void append(T data) {
		if(head == null) head =new Node(data);
		
		else {
			Node temp = head;
			
			while(temp.next !=null) {
				temp = temp.next;
			}
			
			insertAfter(temp, data);
		}
	}
	
	private void insertAfter(Node previousNode, T data){
		previousNode.next = new Node(data, previousNode.next);
	}
	
	public boolean delete(T key) {
		if(head!=null && head.data.equals(key)) {
			head = head.next; return true;
		}
		
		Node temp = head;
		Node previous = null;
		while(temp!=null && !temp.data.equals(key)) {
			previous = temp;
			temp = temp.next;
		}
		if(temp.data.equals(key)){
			previous.next = temp.next;
			return true;
		}
		
		return false;
	}
	
	/// this function modifies the head reference so this must be in LinkedList Class
	public boolean deleteFirst() {
		
		if(head == null) return false;
		head = head.next;
		return true;
	}
	
	/// this function modifies the head reference
	public boolean swap(T data1, T data2) {
		
		if(data1 == null || data2 == null) return false;
		
		Node prev1 = null, prev2 = null, curr1 = null, curr2 = null;
		Node temp = head, prev = null;
		
		while(temp!=null) {
			if(temp.data.equals(data1) || temp.data.equals(data2)) {
				
				if(curr1 == null) {
					prev1 = prev;
					curr1 = temp;
				}else {
					prev2 = prev;
					curr2 = temp;
				}
			}
			prev = temp;
			temp = temp.next;
		}
		if(curr1 == null || curr2 == null) return false;
		
		
		if(prev1 == null) head = curr2;
		else prev1.next = curr2;
		
		if(prev2 == null) head = curr1;
		else prev2.next = curr1;
		
		temp = curr1.next;
		curr1.next = curr2.next;
		curr2.next = temp;
		
		return true;
	}
	
	
	/// This function modifies head reference
	public void reverse() {
		
		if(head == null) return;
		Node curr = head, temp = head.next;
		head.next = null;
		while(temp != null) {
			Node temp1 = temp.next;
			temp.next = curr;
			curr = temp;
			temp = temp1;
		}
		head = curr;
	}
	
	// This function modifies head reference
	public void reverseInGroups(int n) {
		if(head == null) return;
		Node curr = head;
		Node next = null;
		Node prev = null, x = null;
		int count;
		boolean firstTime = true;
		
		while(curr != null) {
			count = 1;
			next = curr!=null?curr.next:null;
			curr.next = null;
			prev = x;
			x = curr;
			
			while(curr != null && count!=n && next!=null) {
				Node next2 = (next!=null)? next.next:null;
				if(next!=null)next.next = curr;
				curr = next;
				next = next2;
				count++;
			}
			
			if(firstTime) {
				firstTime = false;
				head = curr;
				System.out.println(" --- "+curr.data);
			} else {
				prev.next = curr;
				System.out.println(" --- "+curr.data+" "+prev.data+" ---- ");
			}
			
			curr = next;
		}
	}
	
	public void reverse(int n) {
		head = reverse(n, head);
	}
	
	private Node reverse(int n, Node head) {
		
		if(head ==null ) return null;
		Node prev, next; int count = 1;
		next = head.next;
		head.next = null;
		prev = head;
		
		while(count++ < n && head != null && next != null) {
			Node temp = next.next;
			next.next = head;
			head = next;
			next = temp;
		}
		
		prev.next = reverse(n, next);
		
		return head;
	}
}