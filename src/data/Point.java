package data;

public class Point { //T extends Number

	public double[] data;
	
	public Point(double... d) {
		data = d;
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
	
}
