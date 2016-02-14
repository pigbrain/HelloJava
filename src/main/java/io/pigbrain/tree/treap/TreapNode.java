package io.pigbrain.tree.treap;

public class TreapNode {

	private int data;
	private int priority;

	private TreapNode leftChild;
	private TreapNode rightChild;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public TreapNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreapNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreapNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreapNode rightChild) {
		this.rightChild = rightChild;
	}

}
