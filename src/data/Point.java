package data;

public class Point implements TwoWayComparator<Point> {

	public float topLeftX, topLeftY;
	public float widthX, heightY;
	public float centerX, centerY;
	
	public Point(float x, float y, float w, float h) {
		topLeftX = x;
		topLeftY = y;
		widthX = w;
		heightY = y;
		centerX = topLeftX + widthX*2;
		centerY = topLeftY + heightY*2;
	}
	
	public boolean equals(Point p) {
		return topLeftX == p.topLeftX &&
				topLeftY == p.topLeftY &&
				widthX == p.widthX &&
				heightY == p.heightY;
	}
	
	@Override
	public int compareX(Point a, Point b) {
		return (int) (a.topLeftX - b.topLeftX);
	}
	@Override
	public int compareY(Point a, Point b) {
		return (int) (a.topLeftY - b.topLeftY);
	}
	@Override
	public Point[] createChildren() {
		Point[] points = new Point[4];
		points[0] = new Point(topLeftX, topLeftY, widthX/2, heightY/2);
		points[1] = new Point(topLeftX + widthX/2, topLeftY, widthX/2, heightY/2);
		points[2] = new Point(topLeftX, topLeftY + heightY/2, widthX/2, heightY/2);
		points[3] = new Point(topLeftX + widthX/2, topLeftY + heightY/2, widthX/2, heightY/2);
		return points;
	}
	
}
