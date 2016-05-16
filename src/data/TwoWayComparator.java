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
	
}
