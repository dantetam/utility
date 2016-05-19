package data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Point { //T extends Number

	protected double[] data;
	public int dim;
	public Type type;

	public Point(Type t, double... d) {
		type = t;
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
	//public abstract Point combine(List<Point> points);

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
		return new Point(type, temp);
	}

	public Point scale(double factor) {
		Point temp = new Point(type, this.data);
		for (int i = 0; i < temp.data.length; i++) {
			temp.data[i] *= factor;
		}
		return temp;
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

}
