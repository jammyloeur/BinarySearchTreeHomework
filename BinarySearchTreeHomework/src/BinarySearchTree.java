


public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinarySearchTree<E>.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}	
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	
	
	// Method #1.
	public Node findNode(E val) {

		/* IMPLEMENT THIS METHOD! */
		
		// Check whether parameter is null, if so, return null.
		if (val == null) return null;

		Node foundNode = new Node(null);
		foundNode = root;
		
		while (foundNode != null) {
			int cmp = val.compareTo(foundNode.value);

			// Check whether a match is found in the current node.
			if (cmp == 0) {
				return foundNode;
			// Check whether value is less than the value of the current node.
			} else if (cmp < 0) {
				// If the left child is null, value is not contained in the BST.
				if (foundNode.leftChild == null) {
					foundNode = null;
				// Assign the left child as the current node.
				} else {
					foundNode = foundNode.leftChild;
				}
			// Check whether value is greater than the value of the current node.
			} else if (cmp > 0) {
				// If the right child is null, value is not contained in the BST.
				if (foundNode.rightChild == null) {
					foundNode = null;
				// Assign the right child as the current node.
				} else {
					foundNode = foundNode.rightChild;
				}
			}
		}
		
		// Return to calling method.
		return null; 

	}
	
	// Method #2.
	protected int depth(E val) {


		/* IMPLEMENT THIS METHOD! */
		
		// Check whether parameter is null, if so, return -1.
		if (val == null) return -1;

		Node foundNode = new Node(null);
		foundNode = root;
		int depth = 0;
		
		while (foundNode != null) {
			int cmp = val.compareTo(foundNode.value);

			// Check whether a match is found in the current node, if so, return the depth.
			if (cmp == 0) {
				return depth;
			// Check whether value is less than the value of the current node.
			} else if (cmp < 0) {
				// Increment depth by 1.
				depth++;
				// If the left child is null, value is not contained in the BST, so depth is -1.
				if (foundNode.leftChild == null) {
					foundNode = null;
					depth = -1;
				// Assign the left child as the current node.
				} else {
					foundNode = foundNode.leftChild;
				}
			// Check whether value is greater than the value of the current node.
			} else if (cmp > 0) {
				// Increment depth by 1.
				depth++;
				// If the right child is null, value is not contained in the BST, so depth is -1.
				if (foundNode.rightChild == null) {
					foundNode = null;
					depth = -1;
				// Assign the right child as the current node.
				} else {
					foundNode = foundNode.rightChild;
				}
			}
		}
		
		// Return to calling method.
		return depth; 

	}
	
	// Method #3.
	protected int height(E val) {

		/* IMPLEMENT THIS METHOD! */
		
		return -2; // this line is here only so this code will compile if you don't modify it

	}


	// Method #4.
	protected boolean isBalanced(Node n) {

		/* IMPLEMENT THIS METHOD! */
		
		return true; // this line is here only so this code will compile if you don't modify it

	}
	
	// Method #5. .
	public boolean isBalanced() {

		/* IMPLEMENT THIS METHOD! */
		
		return false; // this line is here only so this code will compile if you don't modify it

	}

}
