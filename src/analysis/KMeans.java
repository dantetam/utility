package analysis;

import java.util.ArrayList;
import java.util.List;

import data.Point;

/**
 * 
 * @author Dante
 *
 */

public class KMeans {

	public Point[] nMeans;
	public List<Point>[] separatedPoints;
	
	public KMeans(List<Point> data, int initialMeans, int iterations) {
		if (initialMeans <= 0) {
			throw new IllegalArgumentException("Cannot sort points into less than 1 mean");
		}
		nMeans = new Point[initialMeans];
		separatedPoints = sortPoints(data);
	}
	
	private Point[] getNewCentroids(List<Point>[] separated) {
		if (nMeans[0] == null) {
			throw new RuntimeException("Should sort points first to generate nMeans");
		}
		
	}
	
	private List<Point>[] sortPoints(List<Point> points) {
		if (nMeans[0] == null) {
			for (int i = 0; i < nMeans.length; i++) {
				nMeans[i] = new Point();
			}
		}
		List<Point>[] temp = (List<Point>[]) new Object[nMeans.length];
		for (int i = 0; i < nMeans.length; i++) {
			temp[i] = new ArrayList<Point>();
		}
		for (int i = 0; i < points.size(); i++) {
			int closest = 0; 
			double minDist = points.get(i).dist(nMeans[0]);
			for (int j = 1; j < nMeans.length; j++) {
				double dist = points.get(i).dist(nMeans[j]);
				if (dist < minDist) {
					minDist = dist;
					closest = j;
				}
			}
			temp[closest].add(points.get(i));
		}
		return temp;
	}
	
}
