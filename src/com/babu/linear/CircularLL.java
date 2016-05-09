package com.babu.linear;

public class CircularLL<T extends Comparable<T>> extends LinkedList<T> {

	public CircularLL(){
		super();
	}
	
	@Override
	public void append(T data) {
		if(head == null) {
			head = new Node(data);
			head.next =  head;
		} else {
			head.next = new Node(data, head.next);
			head = head.next;
		}
	}
	
	@Override
	public void push(T data) {
		if(head == null) {
			head = new Node(data);
			head.next =  head;
		} else {
			head.next = new Node(data, head.next);
		}
	}
	
	@Override
	public void printList(LinkedList<T>.Node temp) {
		LinkedList<T>.Node curr = temp.next;
		temp = curr;
		do {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}while(curr != temp);
		System.out.println();
	}
}
