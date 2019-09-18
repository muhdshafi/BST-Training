package tree.training;

import java.util.Arrays;

public class BSTTest {

	public static void main(String[] args) {
		System.out.println("BST Test ...");
		testInsert();
		testDeleteRightLeafNode();
		testDeleteLeftLeafNode();
		testDeleteRightLeafNodeEnd();
		testDeleteLeftLeafNodeBegin();
		testDeleteLeftSubTree();
		testDeleteRightSubTree();
		testDeleteIntermediateNode();
		deleteRootNode();
		System.out.println("All Test cases Passed");
	}

	/**
	 * 
	 * 					 8
	 * 				   /   \	
	 *               5      10
	 *              / \    /  \ 
 	 *             1   7  9    12  
	 */
	private static void testInsert() {
		BST bst = new BST();
		int[] input = {8, 5, 10, 1, 7, 9, 12};
		Arrays.stream(input).forEach(bst::insert);

		assert(bst.size() == 7);
		assert(bst.first() == 1);
		assert(bst.last() == 12);

		System.out.println(bst);
		System.out.println("BSTTest.testInsert() Passed");
	}
	
	private static void testDeleteRightLeafNode() {
		BST bst = new BST();
		int[] input = {8, 5, 10, 1, 7, 9, 12};
		Arrays.stream(input).forEach(bst::insert);
		
		assert(bst.size() == 7);
		assert(bst.first() == 1);
		assert(bst.last() == 12);
		
		bst.delete(7);
		assert(bst.size() == 6);
		assert(bst.first() == 1);
		assert(bst.last() == 12);
		
		System.out.println(bst);
		System.out.println("BSTTest.testDeleteRightLeafNode() Passed");
	}
	
	private static void testDeleteLeftLeafNode() {
		BST bst = new BST();
		int[] input = {8, 5, 10, 1, 7, 9, 12};
		Arrays.stream(input).forEach(bst::insert);
		
		assert(bst.size() == 7);
		assert(bst.first() == 1);
		assert(bst.last() == 12);
		
		bst.delete(9);
		assert(bst.size() == 6);
		assert(bst.first() == 1);
		assert(bst.last() == 12);
		
		System.out.println(bst);
		System.out.println("BSTTest.testDeleteLeftLeafNode() Passed");
	}
	
	private static void testDeleteRightLeafNodeEnd() {
		BST bst = new BST();
		int[] input = {8, 5, 10, 1, 7, 9, 12};
		Arrays.stream(input).forEach(bst::insert);
		
		assert(bst.size() == 7);
		assert(bst.first() == 1);
		assert(bst.last() == 12);
		
		bst.delete(12);
		assert(bst.size() == 6);
		assert(bst.first() == 1);
		assert(bst.last() == 10);
		
		System.out.println(bst);
		System.out.println("BSTTest.testDeleteRightLeafNodeEnd() Passed");
	}
	
	private static void testDeleteLeftLeafNodeBegin() {
		BST bst = new BST();
		int[] input = {8, 5, 10, 1, 7, 9, 12};
		Arrays.stream(input).forEach(bst::insert);
		
		assert(bst.size() == 7);
		assert(bst.first() == 1);
		assert(bst.last() == 12);
		
		bst.delete(1);
		assert(bst.size() == 6);
		assert(bst.first() == 5);
		assert(bst.last() == 12);
		
		System.out.println(bst);
		System.out.println("BSTTest.testDeleteLeftLeafNodeBegin() Passed");
	}

	/**
	 * 
	 * 					   8
	 * 				    /     \	
	 *                5        20
	 *               / \      /  \ 
 	 *              3*   7   15    30  
 	 *             /                
 	 *            1       
 	 *             
	 */
	private static void testDeleteLeftSubTree() {
		BST bst = new BST();
		int[] input = {8, 5, 20, 3, 7, 15, 30, 1};
		Arrays.stream(input).forEach(bst::insert);
		
		assert(bst.size() == 8);
		assert(bst.first() == 1);
		assert(bst.last() == 30);
		
		bst.delete(3);
		assert(bst.size() == 7);
		assert(bst.first() == 1);
		assert(bst.last() == 30);
		
		System.out.println(bst);
		System.out.println("BSTTest.testDeleteLeftSubTree() Passed");
	}
	
	/**
	 * 
	 * 					   8
	 * 				    /     \	
	 *                5        20
	 *               / \      /  \ 
 	 *              3   7   15    30*  
 	 *                             \ 
 	 *                             40 
 	 *                            /  \
 	 *                           35   45
	 */
	private static void testDeleteRightSubTree() {
		BST bst = new BST();
		int[] input = {8, 5, 20, 3, 7, 15, 30, 40, 35, 45};
		Arrays.stream(input).forEach(bst::insert);
		
		assert(bst.size() == 10);
		assert(bst.first() == 3);
		assert(bst.last() == 45);
		
		bst.delete(30);
		assert(bst.size() == 9);
		assert(bst.first() == 3);
		assert(bst.last() == 45);
		
		System.out.println(bst);
		System.out.println("BSTTest.testDeleteRightSubTree() Passed");
	}

	/**
	 * 
	 * 					   8
	 * 				    /     \	
	 *                5        20*
	 *               / \      /  \ 
 	 *              3   7   15    30
 	 *                           /  \ 
 	 *                         25   40 
 	 *                        /    /  \
 	 *                      22    35   45
	 */
	private static void testDeleteIntermediateNode() {
		BST bst = new BST();
		int[] input = {8, 5, 20, 3, 7, 15, 30, 25, 40, 22, 35, 45};
		Arrays.stream(input).forEach(bst::insert);
		
		assert(bst.size() == 12);
		assert(bst.first() == 3);
		assert(bst.last() == 45);
		
		bst.delete(20);
		assert(bst.size() == 11);
		assert(bst.first() == 3);
		assert(bst.last() == 45);
		
		System.out.println(bst);
		System.out.println("BSTTest.testDeleteIntermediateNode() Passed");
	}
	
	/**
	 * 
	 * 					 8*
	 * 				   /   \	
	 *               5      10
	 *              / \    /  \ 
 	 *             1   7  9    12  
	 */
	private static void deleteRootNode() {
		BST bst = new BST();
		int[] input = {8, 5, 10, 1, 7, 9, 12};
		Arrays.stream(input).forEach(bst::insert);

		assert(bst.size() == 7);
		assert(bst.first() == 1);
		assert(bst.last() == 12);

		bst.delete(8);
		
		assert(bst.size() == 6);
		assert(bst.first() == 1);
		assert(bst.last() == 12);
		
		System.out.println(bst);
		System.out.println("BSTTest.testInsert() Passed");
	}
	
	
}
