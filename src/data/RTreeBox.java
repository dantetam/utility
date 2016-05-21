package data;

import java.util.ArrayList;
import java.util.List;

public class RTreeBox<T extends Point> extends Box {

	public static int MAX_CAPACITY = 4;
	public RTreeBox parent;
	public List<RTreeBox> children;
	public List<T> data;
	
	public RTreeBox(RTreeBox par) {
		parent = par;
		children = new ArrayList<RTreeBox>();
		data = new ArrayList<T>();
	}
	
	/**
	 * Insert directly into this ("this" being the child)
	 * Split if #children > RTreeBox.MAX_CAPACITY
	 * @param item - The item to be inserted
	 */
	public void insertMaybeSplit(T item) {
		data.add(item);
		if (data.size() > MAX_CAPACITY) {
			split();
		}
		extendToFitBounds();
	}
	
	/**
	 * Insert into a new child of this RTreeBox, provided there is room
	 * Otherwise, insert into the best child, using the "quadratic" scheme
	 * (minimize gain in area by inserting the child and seeing the new bound).
	 * @param item - The item to be inserted
	 */
	public void insertMaybeSplitNew(T item) {
		if (children.size() < MAX_CAPACITY) {
			RTreeBox temp = new RTreeBox(this);
			children.add(temp);
			temp.insertMaybeSplit(item);
		} else {
			RTreeBox preferred = null; double minAreaChange = 0;
			for (RTreeBox child: children) {
				List<Point> possibleBounds = new ArrayList<Point>();
				possibleBounds.add(child.topLeft);
				possibleBounds.add(child.topLeft.add(child.bounds));
				Point[] bounds = Point.findBounds(possibleBounds);
				double areaBefore = bounds[0].boxDist(bounds[1]);
				possibleBounds.add(item);
				
				bounds = Point.findBounds(possibleBounds);
				double areaChange = bounds[0].boxDist(bounds[1]) - areaBefore;
				
				if (preferred == null || areaChange < minArea) {
					preferred = child;
					minAreaChange = areaChange;
				}
			}
			preferred.insertMaybeSplit(item);
		}
	}
	
	private void split() {
		
	}
	
	/**
	 * Extend this box to fill the bounds of its own children.
	 */
	private void extendToFitBounds() {
		
	}
	
	/**
	 * 
	 */
	/*private Point[] findBounds*/
	
}
