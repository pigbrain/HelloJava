package io.pigbrain.tree.treap;

import org.junit.Assert;
import org.junit.Test;

public class TreapTest {

	@Test
	public void addTest1() {
		Treap treap = new Treap();
		
		treap.add(10, 10);
		treap.add(5, 5);
		treap.add(7, 7);
		
		Assert.assertTrue(treap.getRoot().getData() == 5);
		Assert.assertTrue(treap.getRoot().getRightChild().getData() == 7);
		Assert.assertTrue(treap.getRoot().getRightChild().getRightChild().getData() == 10);
	}
	
	@Test
	public void addTest2() {
		
		Treap treap = new Treap();
		
		treap.add(1, 10);
		treap.add(3, 5);
		treap.add(5, 1);
		

		Assert.assertTrue(treap.getRoot().getData() == 5);
		Assert.assertTrue(treap.getRoot().getLeftChild().getData() == 3);
		Assert.assertTrue(treap.getRoot().getLeftChild().getLeftChild().getData() == 1);
	}
	
	
	@Test
	public void addTest3() {
		
		Treap treap = new Treap();
		
		treap.add(5, 10);
		treap.add(7, 12);
		treap.add(1, 3);
		

		Assert.assertTrue(treap.getRoot().getData() == 1);
		Assert.assertTrue(treap.getRoot().getRightChild().getData() == 5);
		Assert.assertTrue(treap.getRoot().getRightChild().getRightChild().getData() == 7);
	}
	
	@Test
	public void deleteTest1() {
		
		Treap treap = new Treap();
		
		treap.add(10, 10);
		treap.add(5, 5);
		treap.add(7, 7);

		treap.delete(10);
		
		Assert.assertTrue(treap.getRoot().getData() == 5);
		Assert.assertTrue(treap.getRoot().getRightChild().getData() == 7);
		Assert.assertNull(treap.getRoot().getRightChild().getRightChild());
	}
	
	@Test
	public void deleteTest2() {
		
		Treap treap = new Treap();
		
		treap.add(10, 10);
		treap.add(5, 5);
		treap.add(7, 7);

		treap.delete(5);
		
		Assert.assertTrue(treap.getRoot().getData() == 7);
		Assert.assertTrue(treap.getRoot().getRightChild().getData() == 10);
	}
	
	@Test
	public void deleteTest3() {
		
		Treap treap = new Treap();
		
		treap.add(10, 10);
		treap.add(5, 5);
		treap.add(7, 7);

		treap.delete(7);
		
		Assert.assertTrue(treap.getRoot().getData() == 5);
		Assert.assertTrue(treap.getRoot().getRightChild().getData() == 10);
	}
	
	@Test
	public void deleteTest4() {
		
		Treap treap = new Treap();
		
		treap.add(10, 10);
		treap.add(5, 5);
		treap.add(7, 7);
		treap.add(4, 6);

		treap.delete(5);
		
		Assert.assertTrue(treap.getRoot().getData() == 4);
		Assert.assertTrue(treap.getRoot().getRightChild().getData() == 7);
		Assert.assertTrue(treap.getRoot().getRightChild().getRightChild().getData() == 10);
	}
}
