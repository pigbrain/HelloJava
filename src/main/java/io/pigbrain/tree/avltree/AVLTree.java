package io.pigbrain.tree.avltree;

public class AVLTree {

	private AVLNode root;

	public void add(int data) {

		if (root == null) {
			root = new AVLNode();
			root.setData(data);
		} else {
			root = add(root, data);
		}
	}
	
	private AVLNode add(AVLNode node, int data) {
		
		if (node == null) {
			AVLNode newChild = new AVLNode();
			newChild.setData(data);
			return newChild;
		}
		
		if (node.getData() > data) {
			node.setLeftChild(add(node.getLeftChild(), data));
		} else if (node.getData() < data) {
			node.setRightChild(add(node.getRightChild(), data));
		}
				
		return rebalance(node);
	}

	private AVLNode rebalance(AVLNode node) {
		int differenceHeight = getDifferenceHeight(node);
		if (differenceHeight > 1) {
			if (getDifferenceHeight(node.getLeftChild()) > 0) {
				return rotateLL(node);
			} else {
				return rotateLR(node);
			}
		} else if (differenceHeight < -1) {
			if (getDifferenceHeight(node.getRightChild()) < 0) {
				return rotateRR(node);
			} else {
				return rotateRL(node);
			}
		}

		return node;
	}

	private AVLNode rotateLL(AVLNode parent) {
		AVLNode child = parent.getLeftChild();

		parent.setLeftChild(child.getRightChild());

		child.setRightChild(parent);

		return child;
	}

	private AVLNode rotateRR(AVLNode parent) {
		AVLNode child = parent.getRightChild();

		parent.setRightChild(child.getLeftChild());

		child.setLeftChild(parent);

		return child;
	}

	private AVLNode rotateLR(AVLNode parent) {
		AVLNode child = parent.getLeftChild();

		parent.setLeftChild(rotateRR(child));

		return rotateLL(parent);
	}

	private AVLNode rotateRL(AVLNode parent) {
		AVLNode child = parent.getRightChild();

		parent.setRightChild(rotateLL(child));

		return rotateRR(parent);
	}

	private int getHeight(AVLNode node) {
		if (node == null) {
			return 0;
		}

		return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
	}

	private int getDifferenceHeight(AVLNode node) {
		if (node == null) {
			return 0;
		}

		return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
	}
	
	public AVLNode getRoot() {
		return root;
	}

}
