package data;

public class RTree<T extends Point> {

	private RTreeBox<T> root;
	
	public RTree() {
		root = new RTreeBox();
	}
	
	/**
	 * "Alias" for a recursive insert into the root of this R-tree.
	 * @param item - the item to be inserted.
	 */
	public void insert(T item) {
		insert(root, item);
	}
	
	/**
	 * A recursive insert looking at box. If this box has no box children,
	 * it's a leaf (initially, the root is a leaf). This has the following cases:
	 * Not leaf, box contains, no children contain - Insert new box child, split if required,
	 * insert into new box;
	 * Not leaf, box contains, a child contains - Insert into the child;
	 * Leaf, contains - Insert into child directly;
	 * Otherwise, do nothing. 
	 * 
	 * @param box - the box we're currently looking at
	 * @param item - the item to be inserted
	 */
	private void insert(RTreeBox box, T item) {
		
	}
	
}
