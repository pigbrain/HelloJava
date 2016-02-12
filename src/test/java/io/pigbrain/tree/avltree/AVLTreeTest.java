package io.pigbrain.tree.avltree;

import org.junit.Assert;
import org.junit.Test;


public class AVLTreeTest {
	
	@Test
	public void addTest1() {
		AVLTree tree = new AVLTree();
		
		tree.add(5);
		tree.add(3);
		tree.add(1);
		
		AVLNode root = tree.getRoot();
		
		Assert.assertTrue(root.getData() == 3);
		Assert.assertTrue(root.getLeftChild().getData() == 1);
		Assert.assertTrue(root.getRightChild().getData() == 5);
	}
	
	@Test
	public void addTest2() {
		AVLTree tree = new AVLTree();
		
		tree.add(1);
		tree.add(3);
		tree.add(5);
		
		AVLNode root = tree.getRoot();
		
		Assert.assertTrue(root.getData() == 3);
		Assert.assertTrue(root.getLeftChild().getData() == 1);
		Assert.assertTrue(root.getRightChild().getData() == 5);
	}
	
	@Test
	public void addTest3() {
		AVLTree tree = new AVLTree();
		
		tree.add(1);
		tree.add(5);
		tree.add(3);
		
		AVLNode root = tree.getRoot();
		
		Assert.assertTrue(root.getData() == 3);
		Assert.assertTrue(root.getLeftChild().getData() == 1);
		Assert.assertTrue(root.getRightChild().getData() == 5);
	}
	
}
