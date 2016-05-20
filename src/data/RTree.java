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
	 * 
	 * @param box
	 * @param item
	 */
	private void insert(RTreeBox box, T item) {
		if 
	}
	
}
