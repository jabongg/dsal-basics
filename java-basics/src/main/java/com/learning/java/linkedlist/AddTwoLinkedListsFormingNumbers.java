package com.learning.java.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class AddTwoLinkedListsFormingNumbers {

//Java program to add two numbers
//represented by linked list

	static Node head1, head2;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	
	/*
	 * Adds contents of two linked lists and return the head node of resultant list
	 */
	Node addTwoLists(Node first, Node second) {
		// res is head node of the resultant list
		Node res = null;
		Node prev = null;
		Node temp = null;
		int carry = 0, sum;

		// while both lists exist
		while (first != null || second != null) {
			// Calculate value of next
			// digit in resultant list.
			// The next digit is sum
			// of following things
			// (i) Carry
			// (ii) Next digit of first
			// list (if there is a next digit)
			// (ii) Next digit of second
			// list (if there is a next digit)

			sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
			// update carry for next calulation
			carry = (sum >= 10) ? 1 : 0;

			// update sum if it is greater than 10
			sum = sum % 10;

			// Create a new node with sum as data
			temp = new Node(sum);

			// if this is the first node then set
			// it as head of the resultant list
			if (res == null) {
				res = temp;
			}

			// If this is not the first
			// node then connect it to the rest.
			else {
				prev.next = temp;
			}

			// Set prev for next insertion
			prev = temp;

			// Move first and second pointers
			// to next nodes
			if (first != null) {
				first = first.next;
			}
			if (second != null) {
				second = second.next;
			}
		}

		if (carry > 0) {
			temp.next = new Node(carry);
		}

		// return head of the resultant list
		return res;
	}
	/* Utility function to print a linked list */

	void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}

	// Driver Code
	public static void main(String[] args) {
		AddTwoLinkedListsFormingNumbers list = new AddTwoLinkedListsFormingNumbers();

		// creating first list
		list.head1 = new Node(7);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(4);
		list.head1.next.next.next.next = new Node(6);
		list.head1.next.next.next.next.next = new Node(13);
		list.head1.next.next.next.next.next.next = list.head1.next.next.next;
		System.out.print("First List is ");
	
		//list.printList(head1);
		Node loopBeginningNode = list.loopBegginningNode(head1);
		System.out.println(loopBeginningNode.data); // null-pointer if no loop
		
		// creating seconnd list
		list.head2 = new Node(8);
		list.head2.next = new Node(4);
		System.out.print("Second List is ");
		list.printList(head2);

		// add the two lists and see the result
		Node rs = list.addTwoLists(head1, head2);
		System.out.print("Resultant List is ");
		list.printList(rs);
	}
	
	// NOT FOR HIBRID LIST... i.e. list with loops on some nodes but having last node as null.
	public Node loopBegginningNode(Node head) {
		Set<Node> set = new HashSet<>();
		
		while (head != null) {
			
			if (set.contains(head.next)) {
				return head;
			}
			set.add(head);
			head = head.next;
				
		}
		return null; // if there is no loop
	}
	
	
	// if we are allowed to change the structure of the list
	public Node loopBegginningNodeInList(Node head) {
		Node curr = head;
		while (curr.next != null) {
			
			//temp = head;
			curr = curr.next;
			//temp.next = null;
				
		}
		Node lastNode = curr;
		return null; // if there is no loop
	}
}
