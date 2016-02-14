package io.pigbrain.tree.treap;

import io.pigbrain.tree.avltree.AVLNode;

import java.util.Random;

public class Treap {

	private TreapNode root;

	private void add(int data) {

		add(data, getPriority());
	}

	public void add(int data, int priority) {

		root = add(root, data, priority);
	}

	public void delete(int data) {

	}

	private TreapNode add(TreapNode node, int data, int priority) {

		if (node == null) {
			TreapNode newChild = new TreapNode();
			newChild.setData(data);
			newChild.setPriority(priority);

			return newChild;
		}

		if (node.getData() > data) {
			node.setLeftChild(add(node.getLeftChild(), data, priority));
		} else if (node.getData() < data) {
			node.setRightChild(add(node.getRightChild(), data, priority));
		}

		return rebalance(node);
	}

	private TreapNode rebalance(TreapNode node) {

		if (node.getLeftChild() == null && node.getRightChild() == null) {
			return node;
		}

		if (node.getLeftChild() != null
				&& node.getLeftChild().getPriority() < node.getPriority()) {
			return rotateLL(node);
		}

		if (node.getRightChild() != null
				&& node.getRightChild().getPriority() < node.getPriority()) {
			return rotateRR(node);
		}

		return node;
	}

	private TreapNode rotateLL(TreapNode parent) {

		TreapNode child = parent.getLeftChild();

		parent.setLeftChild(child.getRightChild());
		child.setRightChild(parent);

		return child;
	}

	private TreapNode rotateRR(TreapNode parent) {

		TreapNode child = parent.getRightChild();

		parent.setRightChild(child.getLeftChild());
		child.setLeftChild(parent);

		return child;
	}

	private TreapNode getRoot() {
		return root;
	}

	private int getPriority() {
		Random random = new Random();
		return random.nextInt(Integer.MAX_VALUE);
	}
}
