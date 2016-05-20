package data;

public class QuadTreeBox extends Box implements TwoWayComparator<QuadTreeBox> {
	
	public QuadTreeBox(Point t, Point b) {
		super(t,b);
	}
	
	public QuadTreeBox(double x, double y, double w, double h) {
		super(new Point(x, y), new Point(w, h));
	}
	
	public boolean equals(QuadTreeBox p) {
		return topLeft.equals(p.topLeft) &&
				bounds.equals(p.bounds);
	}
	
	@Override
	public int compareX(QuadTreeBox a, QuadTreeBox b) {
		return (int) (a.topLeft.data()[0] - b.topLeft.data()[0]);
	}
	@Override
	public int compareY(QuadTreeBox a, QuadTreeBox b) {
		return (int) (a.topLeft.data()[1] - b.topLeft.data()[1]);
	}
	@Override
	public QuadTreeBox[] createChildren() {
		QuadTreeBox[] points = new QuadTreeBox[4];
		double topLeftX = topLeft.data()[0], topLeftY = topLeft.data()[1];
		double widthX = bounds.data()[0], heightY = bounds.data()[1];
		points[0] = new QuadTreeBox(topLeftX, topLeftY, widthX/2, heightY/2);
		points[1] = new QuadTreeBox(topLeftX + widthX/2, topLeftY, widthX/2, heightY/2);
		points[2] = new QuadTreeBox(topLeftX, topLeftY + heightY/2, widthX/2, heightY/2);
		points[3] = new QuadTreeBox(topLeftX + widthX/2, topLeftY + heightY/2, widthX/2, heightY/2);
		return points;
	}
	
}
