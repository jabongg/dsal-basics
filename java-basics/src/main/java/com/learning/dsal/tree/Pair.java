package com.learning.dsal.tree;

// This class is used to store key value pairs of node and its corresponding horizontal distance.
public class Pair {
	BSTNode node;
	int horizontalDistance;

	public Pair(BSTNode node, int horizontalDistance) {
		super();
		this.node = node;
		this.horizontalDistance = horizontalDistance;
	}
}
