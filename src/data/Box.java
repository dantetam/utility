package data;

public class Box implements TwoWayComparator<Box> {

	public float topLeftX, topLeftY;
	public float widthX, heightY;
	public float centerX, centerY;
	
	public Box(float x, float y, float w, float h) {
		topLeftX = x;
		topLeftY = y;
		widthX = w;
		heightY = y;
		centerX = topLeftX + widthX*2;
		centerY = topLeftY + heightY*2;
	}
	
	public boolean equals(Box p) {
		return topLeftX == p.topLeftX &&
				topLeftY == p.topLeftY &&
				widthX == p.widthX &&
				heightY == p.heightY;
	}
	
	@Override
	public int compareX(Box a, Box b) {
		return (int) (a.topLeftX - b.topLeftX);
	}
	@Override
	public int compareY(Box a, Box b) {
		return (int) (a.topLeftY - b.topLeftY);
	}
	@Override
	public Box[] createChildren() {
		Box[] points = new Box[4];
		points[0] = new Box(topLeftX, topLeftY, widthX/2, heightY/2);
		points[1] = new Box(topLeftX + widthX/2, topLeftY, widthX/2, heightY/2);
		points[2] = new Box(topLeftX, topLeftY + heightY/2, widthX/2, heightY/2);
		points[3] = new Box(topLeftX + widthX/2, topLeftY + heightY/2, widthX/2, heightY/2);
		return points;
	}
	
}
