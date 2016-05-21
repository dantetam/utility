package data;

import java.util.ArrayList;
import java.util.List;

public class RTreeBox<T extends Point> extends Box {

	public static int MAX_CAPACITY = 4;
	public List<RTreeBox> children;
	public List<T> data;
	
	public RTreeBox() {
		children = new ArrayList<RTreeBox>();
		data = new ArrayList<T>();
	}
	
	/**
	 * Insert directly into this ("this" being the child)
	 * @param item
	 */
	public void insertMaybeSplit(T item) {
		data.add(item);
		if (data.size() > MAX_CAPACITY) {
			split();
		}
		extendToFitBounds();
	}
	
	public void insertMaybeSplitNew(T item) {
		if (children.size() < MAX_CAPACITY) {
			RTreeBox temp = new RTreeBox();
			children.add(temp);
			temp.insertMaybeSplit(item);
		} else {
			RTreeBox preferred = 
			for (RTreeBox child: children) {
				
			}
		}
	}
	
	private void split() {
		
	}
	
	/**
	 * 
	 */
	private void extendToFitBounds() {
		
	}
	
	/**
	 * 
	 */
	private Point
	
}
