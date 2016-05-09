package com.linear.linkedlist;
public class DoubleLinkedList<T extends Comparable<T>> {
	private Node head;
	private Node tail;
	public Node getHead() {
		return head;
	}
	
	private class Node {
		public T data;
		public Node prev, next;
		public Node(T data, DoubleLinkedList<T>.Node prev, DoubleLinkedList<T>.Node next) {
			super();
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
	}
	
	// May modify tail;
	public void push(T data) {
		if(head == null) tail = head = new Node(data, null, null);
		else {
			head.prev = new Node(data, null, head);
			head = head.prev;
		}
	}
	
	// May modify head pointer
	// Better to store last pointer, to avoid O(n) time complexity.
	public void append(T data) {
		tail.next = new Node(data, tail, null);
		tail = tail.next;
	}
	
	// May modify tail reference
	public boolean insertAfter(T key, T data) {
		Node temp = head;
		while(temp != null && !temp.data.equals(key)) {
			temp = temp.next;
		}
		if(temp == null) return false;
		
		temp.next = new Node(data, temp, temp.next);
		if(temp == tail) tail =temp.next;
		return true;
		
	}
	
	// Might modify head pointer
	public boolean insertBefore(T key, T data) {
		Node temp = tail;
		while(temp != null && !temp.data.equals(key)) {
			temp = temp.prev;
		}
		
		if(temp == null) return false;
		
		temp.prev = new Node(data, temp.prev, temp);
		if(temp == head) head = temp.prev;

		return true;
	}
	
	//May modify head and tail 
	public boolean delete(T key) {
		Node temp = head;
		while(!temp.data.equals(key)) {
			temp = temp.next;
		}
		
		if(temp == null) return false;
		
		if(temp == head) {
			head.next.prev = null;
			head = head.next;
		}		
		
		else if(temp == tail) {
			tail.prev.next = null;
			tail = tail.prev;
		} else {
			temp.next.prev = temp.prev;
			temp.prev.next = temp.next;
		}
		return true;
		
	}
	
	public void reverse() {
		if (head == null) { // if head is not null, tail cannot be null
			return;
		}
		Node temp = head;
		head = tail;
		tail = temp;
		
		while(temp != null) {
			Node temp1 = temp.next;
			temp.next = temp.prev;
			temp = (temp.prev = temp1);
		}
	}
	
	// Won't modify head pointer
	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
}
