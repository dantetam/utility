package data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Point { //T extends Number

	protected double[] data;
	public int dim;

	public Point(double... d) {
		//type = t;
		data = d;
		dim = data.length;
	}

	/**
	 * Provide accessor and mutator to assure correctness of dim
	 * @param d
	 */
	public void changeData(double... d) {
		data = d;
		dim = data.length;
	}

	public double[] data() {
		return data;
	}
	
	/**
	 * @param points - A set of points that represent neighbors
	 * @return A new type that "dominates" the set 
	 */
	protected static Type determineNewType(List<Point> points) {
		Map<Type, Integer> temp = new HashMap<Type, Integer>();
		return Collections.max(temp.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
		/*Type max = null; int maxVal = -1;
		for (Point p: points) {
			int val = temp.getOrDefault(p.type, 0) + 1;
			temp.put(p.type, val);
			if (val > maxVal) {
				maxVal = val;
				max = p.type;
			}
		}
		return max;*/
	}
	
	/**
	 * @param points - A set of points to be combined into an "average"
	 * @return The new point
	 */
	public static Point combinePoints(List<Point> points) {
		Point avg = new Point();
		avg.changeData(points.get(0).data);
		for (int j = 0; j < points.size(); j++) {
			avg = avg.add(points.get(j));
		}
		//for (int j = 0; j < nMeans[i].dim; j++) {
		avg = avg.scale(1D/(double)points.size());
		//}
		return avg;
	}

	/**
	 * Non-destructively adds other to this point
	 * @param other - The point to be added to this point
	 * @return The new point
	 */
	public Point add(Point other) {
		if (data.length != other.data.length) {
			throw new RuntimeException("Comparing points of different dimensions");
		}
		double[] temp = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i] + other.data[i];
		}
		return new Point(temp);
	}

	public Point scale(double factor) {
		Point temp = new Point(this.data);
		for (int i = 0; i < temp.data.length; i++) {
			temp.data[i] *= factor;
		}
		return temp;
	}
	
	public Point avg(Point other) {
		return this.add(other).scale(0.5D);
	}

	public double dist(Point other) {
		if (data.length != other.data.length) {
			throw new RuntimeException("Comparing points of different dimensions");
		}
		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			double t = data[i] - other.data[i];
			sum += t*t;
		}
		return Math.sqrt(sum);
	}
	
	/**
	 * Where this and other are N-dimensional points, 
	 * return the area/volume within the N-dimensional solid defined
	 * by this point and other.
	 * @param other - The other point to be compared to
	 * @return a "volume"
	 */
	public double boxDist(Point other) {
		if (data.length != other.data.length) {
			throw new IllegalArgumentException("Comparing points of different dimensions");
		}
		double product = 1;
		for (int i = 0; i < data.length; i++) {
			double t = data[i] - other.data[i];
			product *= Math.abs(t);
		}
		return product;
	}

	/**
	 * 
	 * @param points - A list of points to be checked
	 * @return A new double[2]{min, max}, where
	 * min represents the lowest fields of every point and
	 * max represents the highest fields.
	 */
	public static double[][] minMax(List<Point> points) {
		if (points.size() == 0) {
			throw new RuntimeException("Not comparing any points");
		}
		int firstDim = points.get(0).dim;
		for (int i = 1; i < points.size(); i++) {
			if (points.get(i).dim != firstDim) {
				throw new RuntimeException("Min-max points of different dimensions");
			}
		}
		double[] min = points.get(0).data;
		double[] max = points.get(0).data;
		if (points.size() != 1) {
			for (int i = 1; i < points.size(); i++) {
				double[] p = points.get(i).data();
				for (int j = 1; j < min.length; j++) {
					if (p[j] < min[j]) {
						min[j] = p[j];
					} else if (p[j] > max[j]) {
						max[j] = p[j];
					}
				}
			}
		}
		return new double[][]{min, max};
	}
	
	/**
	 * Same as min-max but returns in a convenient point form
	 * @param points - Points of the calculated bound
	 * @return an array of 2 points containing absolute positions
	 * of the upper left and lower right corners of the bound
	 */
	public static Point[] findBounds(List<Point> points) {
		double[][] temp = minMax(points);
		return new Point[]{new Point(temp[0]), new Point(temp[1])};
	}
	
	public int hashCode() {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
			sum %= 6700417;
		}
		return sum;
	}

}
