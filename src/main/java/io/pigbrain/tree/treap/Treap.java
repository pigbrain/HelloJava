package io.pigbrain.tree.treap;


import java.util.Random;

public class Treap {

	private TreapNode root;

	private void add(int data) {

		add(data, getPriority());
	}

	public void add(int data, int priority) {

		root = add(root, data, priority);
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

		if (node.getLeftChild() != null	&& node.getLeftChild().getPriority() < node.getPriority()) {
			return rotateLL(node);
		}

		if (node.getRightChild() != null && node.getRightChild().getPriority() < node.getPriority()) {
			return rotateRR(node);
		}
 
		return node;
	}
	

	public void delete(int data) {
		
		delete(null, root, data);
	}
	
	private void delete(TreapNode parentNode, TreapNode node, int data) {
		
		if (node == null) {
			return;
		}
		
		if (node.getData() > data) {
			delete(node, node.getLeftChild(), data);
			return;
		} else if (node.getData() < data) {
			delete(node, node.getRightChild(), data);
			return;
		}
		
		// Target node is a leaf
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			if (parentNode != null && parentNode.getLeftChild() != null && parentNode.getLeftChild().getData() == data) {
				parentNode.setLeftChild(null);
			} else if (parentNode != null && parentNode.getRightChild() != null &&  parentNode.getRightChild().getData() == data) {
				parentNode.setRightChild(null);
			}
			
			return;
		}
		
		// Target node has one child node.
		if (node.getLeftChild() == null || node.getRightChild() == null) {
			if (node.getLeftChild() == null) {
				// rotateRR
				TreapNode rotatedNode = rotateRR(node);
				
				deleteInRotated(parentNode, rotatedNode, data);
			} else {
				// rotateLL
				TreapNode rotatedNode = rotateLL(node);
				
				deleteInRotated(parentNode, rotatedNode, data);
			}
			
			return;
		}
		
		// Target node's children are full
		if (node.getLeftChild() != null && node.getRightChild() != null) {
			if (node.getLeftChild().getPriority() < node.getRightChild().getPriority()) {
				TreapNode rotatedNode = rotateLL(node);
				
				deleteInRotated(parentNode, rotatedNode, data);
			} else {
				TreapNode rotatedNode = rotateRR(node);
				
				deleteInRotated(parentNode, rotatedNode, data);
			}
		}
	}
	
	private void deleteInRotated(TreapNode parentNode, TreapNode rotatedNode, int data) {
		
		if (parentNode != null && parentNode.getLeftChild() != null && parentNode.getLeftChild().getData() == data) {
			parentNode.setLeftChild(rotatedNode);
			delete(parentNode, parentNode.getLeftChild(), data);
		} else if (parentNode != null && parentNode.getRightChild() != null &&  parentNode.getRightChild().getData() == data) {
			parentNode.setRightChild(rotatedNode);;
			delete(parentNode, parentNode.getRightChild(), data);
		} else {
			root = rotatedNode;
			delete(null, root, data);
		}
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

	public TreapNode getRoot() {
		return root;
	}

	private int getPriority() {
		Random random = new Random();
		return random.nextInt(Integer.MAX_VALUE);
	}
}
