package com.greatlearning.dsa.assignment.problem2solution;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.left.right = new Node(40);

		tree.flattenBTToSkewed(tree.node);
		tree.traverseRightSkewed(tree.headNode);
	}
}