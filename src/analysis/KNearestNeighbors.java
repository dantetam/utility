package analysis;

import java.util.List;

import data.Point;

public class KNearestNeighbors {

	public List<Point> data;
	public List<Point> newData;
	
	public KNearestNeighbors(List<Point> data) {
		this.data = data;
		newData = new ArrayList<Point>();
	}
	
}
