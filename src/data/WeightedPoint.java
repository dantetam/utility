package data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedPoint extends Point {

	public MultiType types;
	
	public WeightedPoint(MultiType t, double... d) {
		super(null, d);
		// TODO Auto-generated constructor stub
	}
	
	protected static MultiType determineNewType(List<WeightedPoint> points) {
		Map<Type, Integer> temp = new HashMap<Type, Integer>();
		return Collections.max(temp.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
		/*Type max = null; int maxVal = -1;
		for (Point p: points) {
			int val = temp.getOrDefault(p.type, 0) + 1;
			temp.put(p.type, val);
			if (val > maxVal) {
				maxVal = val;
				max = p.type;
			}
		}
		return max;*/
	}
	
	public static WeightedPoint combine(List<WeightedPoint> points) {
		Point avg = new WeightedPoint(determineNewType(points));
		avg.changeData(points.get(0).data);
		for (int j = 0; j < points.size(); j++) {
			avg = avg.add(points.get(j));
		}
		//for (int j = 0; j < nMeans[i].dim; j++) {
		avg = avg.scale(1D/(double)points.size());
		//}
		return (WeightedPoint) avg;
	}
	
}
