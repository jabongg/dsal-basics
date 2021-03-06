package com.learning.java.linkedlist;

public class ListDriver {

	public static void main(String[] args) {
		
		// start with empty list
		
		LinkedNode l1  = null;
		LinkedNode l2 = null;
		LinkedNode l3 = null;
		
		// create l1 list 
		l1 = List.insert(l1, 2);
		l1 = List.insert(l1, 4);
		l1 = List.insert(l1, 3);
		l1 = List.insert(l1, 9);
		
		List.print(l1);
		System.out.println();
		
		// create l2 list
		l2 = List.insert(l2, 5);
		l2 = List.insert(l2, 6);
		l2 = List.insert(l2, 4);
		List.print(l2);
		
		System.out.println();
		
		System.out.println("adding two numbers:");
		l3 = List.addTwoNumbers(l1, l2);
		List.print(l3);
		
		System.out.println();
		
		

		/**
		 * odd even list
		 */
		System.out.println("odd even list");
		LinkedNode oddEvenList = null;
		oddEvenList= List.insert(oddEvenList, 15);
		oddEvenList= List.insert(oddEvenList, 14);
		oddEvenList= List.insert(oddEvenList, 3);
		oddEvenList= List.insert(oddEvenList, 2);
		oddEvenList= List.insert(oddEvenList, 17);
		oddEvenList= List.insert(oddEvenList, 29);
		oddEvenList= List.insert(oddEvenList, 90);
		oddEvenList= List.insert(oddEvenList, 1);
		
		List.print(oddEvenList);
		System.out.println();

	    LinkedNode resultantOddEvenList = List.oddEvenList(oddEvenList);
		List.print(resultantOddEvenList);
		
		/** intersection point of two linked list*/
		System.out.println();
		System.out.println("intersection point of two linked list");
		LinkedNode headA = null;
		LinkedNode headB = null;

		headA= List.insert(headA, 4);
		headA= List.insert(headA, 1);
		headA= List.insert(headA, 8);
		headA= List.insert(headA, 4);
		headA= List.insert(headA, 5);

		 
		headB= List.insert(headB, 5);
		headB= List.insert(headB, 6);
		headB.next.next = headA.next.next; // merging the two lists
		
		System.out.println();
		List.print(headA);
		System.out.println();
		List.print(headB);
		System.out.println();

//		headB= List.insert(headB, 1);
//		headB= List.insert(headB, 8);
//		headB= List.insert(headB, 4);
//		headB= List.insert(headB, 5);

		
		List.print(List.getIntersectionNode(headA, headB));
		

	}
}
