package data;

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
	
	public double[] minMax(List<Point> data) {
		
	}
	
}
