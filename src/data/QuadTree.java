package data;

/**
 * @author Dante Tam
 * 
 * A utility QuadTree class used for efficiently loading chunks, and finding objects within them
 */

public class QuadTree<T extends TwoWayComparator<T>> {

	private Node root;
	
	//Do not expose Node intrinsics to usable QuadTree class
	private class Node {
		public T item;
		private Node[] children;
		
		
	}
	
}
