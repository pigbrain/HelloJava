package io.pigbrain.tree.avltree;

public class AVLNode {

	private int data;
	private AVLNode leftChild;
	private AVLNode rightChild;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public AVLNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(AVLNode leftChild) {
		this.leftChild = leftChild;
	}

	public AVLNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(AVLNode rightChild) {
		this.rightChild = rightChild;
	}

}
