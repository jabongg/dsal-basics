package com.learning.java.linkedlist;

public class List {

	public static LinkedNode insert(LinkedNode head, int data) {
		LinkedNode newNode = new LinkedNode(data);
		
		if (head == null) {
			head = newNode;
		} else {
			LinkedNode curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			
			curr.next = newNode;
		}
		
		// append at the end of the list		
		
		return head;
	}
	
	// add two numbers represented as linked list
    public static LinkedNode addTwoNumbers(LinkedNode l1, LinkedNode l2) {
    	LinkedNode dummyHead = new LinkedNode(0);
    	LinkedNode l3 = dummyHead;
    	
    	int carry = 0;
    	
    	while (l1 != null || l2 != null) {
    		int l1Value = (l1 != null) ? l1.data : 0;
    		int l2Value = (l2 != null) ? l2.data : 0;
    		
    		int currentSum = l1Value + l2Value + carry;
    		carry  = currentSum / 10;
    		
    		int lastDigit = currentSum % 10;
    		LinkedNode newNode = new LinkedNode(lastDigit);
    		l3.next = newNode;
    		
    		if (l1 != null) l1 = l1.next;
    		if (l2 != null) l2 = l2.next;
    		l3 = l3.next;

    	} 
    	
    	// handling carry
    	if (carry > 0) {
    		LinkedNode newNode = new LinkedNode(carry);
    		l3.next = newNode;
    		l3 = l3.next;
    	}
		return dummyHead.next;    	
    }

    // in place solution
    public static LinkedNode oddEvenList(LinkedNode head) {
        if (head == null) return null; //boundary condition
        LinkedNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenHead;
        return head;
    }
    
    
    public static LinkedNode getIntersectionNode(LinkedNode headA, LinkedNode headB) {
    	int lengthA = 0, lengthB = 0;
    	
    	LinkedNode ptrA = headA;
    	LinkedNode ptrB = headB;
    	
    	while (ptrA != null) {
    		ptrA = ptrA.next;
    		lengthA++;
    	}
    	
 
    	while (ptrB != null) {
    		ptrB = ptrB.next;
    		lengthB++;
    	}

    	System.out.println(lengthA + " " + lengthB);    	
		return headB;
        
    }
    
    static public void print(LinkedNode head) {
    	while (head != null) {
    		System.out.print(head.data);
    		System.out.print(" ");
    		head = head.next;
    	}
    }
}
