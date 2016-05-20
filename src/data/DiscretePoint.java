package data;

import java.util.List;

public class DiscretePoint extends Point {

	public Type type;
	
	public DiscretePoint(Type t, double... d) {
		super(d);
		type = t;
		// TODO Auto-generated constructor stub
	}
	
	public static Point combine(List<Point> points) {
		Point avg = new DiscretePoint(determineNewType(points));
		avg.changeData(points.get(0).data);
		for (int j = 0; j < points.size(); j++) {
			avg = avg.add(points.get(j));
		}
		//for (int j = 0; j < nMeans[i].dim; j++) {
		avg = avg.scale(1D/(double)points.size());
		//}
		return avg;
	}
	
}
