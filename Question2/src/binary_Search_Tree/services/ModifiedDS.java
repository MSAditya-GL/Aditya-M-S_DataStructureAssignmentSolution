package binary_Search_Tree.services;

public class ModifiedDS {

	public Node node;
	static Node prev = null;
	public Node head = null;

	public void populateSkew(Node root, int sOrder) {
		if (root == null) {
			return;
		}
		if (sOrder > 0) {
			populateSkew(root.right, sOrder);
		} else {
			populateSkew(root.left, sOrder);
		}

		Node rightNode = root.right;
		Node leftNode = root.left;

		if (head == null) {
			head = root;
			root.left = null;
			prev = root;
		} else {
			prev.right = root;
			root.left = null;
			prev = root;
		}

		if (sOrder > 0) {
			populateSkew(leftNode, sOrder);
		} else {
			populateSkew(rightNode, sOrder);
		}
	}

	public void BinaryToSkew(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.nodeData + " ");
		BinaryToSkew(root.right);
	}
}
