package binary_Search_Tree.main;

import binary_Search_Tree.services.ModifiedDS;
import binary_Search_Tree.services.Node;

public class DriverClass {

	public static void main(String[] args) {

		ModifiedDS tree = new ModifiedDS();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		System.out.println("Input: ");
		int[] arr = { tree.node.nodeData, tree.node.left.nodeData, tree.node.right.nodeData,
				tree.node.left.left.nodeData, tree.node.right.left.nodeData };

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println('\n');

		int sortOrder = 0; // for values present in ascending order
		tree.populateSkew(tree.node, sortOrder);

		System.out.println("Output: ");
		tree.BinaryToSkew(tree.head);

	}

}
