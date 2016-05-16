package data;

import java.util.Comparator;

public interface TwoWayComparator<T> extends Comparator<T> {

	//Install a 'natural ordering' by chaining x and y compare
	public default int compare(T a, T b) {
		int dy = compareY(a, b);
		if (dy != 0) {
			return dy;
		}
		return compareX(a, b);
	}
	
	public boolean equals(Object a);
	
	public int compareX(T a, T b);
	public int compareY(T a, T b);
	
	public T[] createChildren();
	public default int getCompareScores(T a, T b) {
		int dy = compareY(a, b);
		int dx = compareX(a, b);
		if (dy == dx && dx == 0) {
			throw new RuntimeException("a and b should not be equal");
		}
		if (dy > 1 && dx > 1) return 3;
		if (dy > 1 && dx < 1) return 2;
		if (dx > 1) return 1;
		return 0;
	}
	
}
