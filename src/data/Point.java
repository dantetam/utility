package data;

import java.util.List;

public class Point { //T extends Number

	private double[] data;
	public int dim;
	public Type type;

	public Point(Type t, double... d) {
		type = t;
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
	
	public static Point determineNewType(List<Point> points) {
		
	}
	
	public static Point combine(List<Point> points) {
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
