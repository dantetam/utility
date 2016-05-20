package data;

public class Box {

	/*public float topLeftX, topLeftY;
	public float widthX, heightY;
	public float centerX, centerY;*/
	
	public Point topLeft;
	public Point bounds;
	public Point center;
	
	public Box(Point t, Point b) {
		topLeft = t;
		bounds = b;
		center = t.avg(b);
	}
	
}
