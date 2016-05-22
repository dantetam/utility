package data;

public class Box {

	/*public float topLeftX, topLeftY;
	public float widthX, heightY;
	public float centerX, centerY;*/
	
	public Point topLeft;
	public Point bounds;
	public Point center;
	
	public Box() {
		
	}
	
	public Box(Point t, Point b) {
		if (t.dim != b.dim) {
			throw new IllegalArgumentException("Cannot create box with varying dimensions");
		}
		topLeft = t;
		bounds = b;
		center = t.avg(b);
	}
	
	public boolean contains(Point point) {
		//boolean contains = true;
		if (topLeft.dim != point.dim) {
			throw new IllegalArgumentException("Cannot compare points of different dimensions");
		}
		double[] t = topLeft.data(), b = bounds.data(), p = point.data();
		for (int i = 0; i < point.dim; i++) {
			if (!(p[i] > t[i] && p[i] < t[i] + b[i])) 
				return false;
		}
		return true;
	}
	
	public int hashCode() {
		return topLeft.hashCode() + bounds.hashCode();
	}
	
	public boolean equals(Object other) {
		if (!(other instanceof Box)) return false;
		Box b = (Box) other;
		return topLeft.equals(b.topLeft) && bounds.equals(b.bounds);
	}
	
}
