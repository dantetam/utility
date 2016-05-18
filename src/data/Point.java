package data;

import java.util.List;

public class Point { //T extends Number

	private double[] data;
	public int dim;

	public Point(double... d) {
		data = d;
		dim = data.length;
	}

	public void changeData(double... d) {
		data = d;
		dim = data.length;
	}

	public double[] data() {
		return data;
	}

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
