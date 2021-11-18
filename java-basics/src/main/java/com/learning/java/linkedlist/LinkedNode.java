package com.learning.java.linkedlist;
/**
 * linkedNode
 * @author User
 *
 */
public class LinkedNode {

	LinkedNode next;
	int data;
	
	LinkedNode() {}
	
	LinkedNode(int data, LinkedNode next) { this.data = data; this.next = next; }
	
	public LinkedNode(int data) {
		this.next = null;
		this.data = data;
	}
}
