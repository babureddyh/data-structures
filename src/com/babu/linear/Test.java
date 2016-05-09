package com.babu.linear;

import java.util.Scanner;

public class Test {

	public static void main(String args) {
		Scanner scan = new Scanner(System.in);
		int a;
		LinkedList<Integer> list = new LinkedList<>();
		
		while((a = scan.nextInt())!=-1) {
			list.append(a);
		}
		
//		list.insertAfter(2, 2345);
//		list.append(5432);
//		list.delete(new Integer(2));
		list.printList(null);
		
//		list.swap(2,3);
//		
//		list.reverse();
		list.reverse(2);
		list.printList(null);
		
	}
	
	public static void main(String[] args) {
//		LinkedList<Integer> list1 = new LinkedList<Integer>();
//		LinkedList<Integer> list2 = new LinkedList<Integer>();
//		list1.append(1);
//		list2.append(2);
//		list1.append(3);
//		list1.append(5);
//		list2.append(6);
//		list1.append(7);
//		list1.append(8);
//		
//		list1.printList(LinkedListPrograms.<Integer>merge(list1.head, list2.head));
		
		LinkedList<Integer> list1 = new CircularLL<Integer>();
		list1.append(1);
		list1.append(2);
		list1.append(3);
		list1.append(4);
		list1.append(5);
		list1.printList(list1.head);
	}
}
