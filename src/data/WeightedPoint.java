package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedPoint extends Point {

	public MultiType mt;
	
	public WeightedPoint(MultiType t, double... d) {
		super(d);
		mt = t;
		// TODO Auto-generated constructor stub
	}
	
	protected static MultiType determineNewMultiType(List<WeightedPoint> points) {
		WeightedPoint base = points.get(0);
		for (int i = 1; i < points.size(); i++) {
			if (!base.mt.sameTypes(points.get(i).mt)) {
				throw new RuntimeException("Cannot compare WeightedPoint of different types");
			}
		}
		HashMap<Type, Double> weights = new HashMap<Type, Double>();
		MultiType firstMt = points.get(0).mt;
		List<Type> types = new ArrayList<Type>();
		for (int i = 0; i < firstMt.types.size(); i++) {
			types.add(firstMt.types.get(i));
			weights.put(firstMt.types.get(i), firstMt.weights.get(i));
		}
		for (int i = 1; i < points.size(); i++) {
			MultiType mt = points.get(0).mt;
			for (int j = 0; j < mt.types.size(); j++) {
				weights.put(mt.types.get(i), weights.get(mt.types.get(i)) + mt.weights.get(i));
			}
		}
		Double[] newWeights = (Double[]) weights.values().toArray();
		List<Double> averaged = new ArrayList<Double>();
		double sum = 0;
		for (double d: newWeights) sum += d;
		for (int i = 0; i < newWeights.length; i++) {
			averaged.add(newWeights[i]/sum);
		}
		return new MultiType(types, averaged);
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
		Point avg = new WeightedPoint(determineNewMultiType(points));
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
