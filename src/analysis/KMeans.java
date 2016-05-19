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
	
	private Point[] randomNMeans(List<Point> data) {
		Point[] temp = new Point[nMeans.length];
		double[][] minMax = Point.minMax(data);
		double[] min = minMax[0], max = minMax[1];
		for (int i = 0; i < nMeans.length; i++) {
			temp[i] = new Point();
			double[] newMean = new double[min.length];
			for (int j = 0; j < min.length; j++) {
				newMean[j] = min[j] + Math.random() * (max[j]-min[j]);
			}
			temp[i].changeData(newMean);
		}
		return temp;
	}
	
	private Point[] getNewCentroids(List<Point>[] separated) {
		if (nMeans[0] == null) {
			throw new RuntimeException("Should sort points first to generate nMeans");
		}
		Point[] temp = new Point[nMeans.length];
		for (int i = 0; i < nMeans.length; i++) {
			Point avg = Point.combine(separated[i]);
			temp[i] = avg;
		}
		return temp;
	}
	
	private List<Point>[] sortPoints(List<Point> points) {
		if (nMeans[0] == null) {
			nMeans = randomNMeans(points);
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
