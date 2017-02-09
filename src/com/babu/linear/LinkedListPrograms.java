package com.babu.linear;

import com.babu.linear.LinkedList.Node;

public class LinkedListPrograms{
	
	
	
	////////////////Lenght/////////////////
	

	public static <T> int lengthIterative(Node head) {
		int length = 0;
		
		while(head!=null){
			length++;
			head = head.next;
		}
		
		return length;
	}
	
	public static <T> int lengthRecursive(Node head) {
		// base case
		if(head == null) return 0;
		return 1 + lengthRecursive(head.next);
	}
	
	public static <T extends Comparable<T>> LinkedList<T>.Node merge(LinkedList<T>.Node list1, LinkedList<T>.Node list2) {
		
		LinkedList<T>.Node list2Next = null, list1Prev = null, toRet = list1;
		while(list2 != null) {
			list2Next = list2.next;
			while(list1 != null && list1.data.compareTo(list2.data) < 0) {
				list1Prev = list1;
				list1 = list1.next;
			}
			
			if(list1 == null) {
				list1Prev.next = list2;
				break;
			}else {
				list2.next = list1;
				list1Prev.next = list2;
				list1Prev = list2;
			}
			
			list2 = list2Next;
		}
		
		return toRet;
	}
	////////////////////////////////////////////
}
