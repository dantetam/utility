package data;

import java.util.List;

public class MultiType {

	public List<Type> types;
	public List<Double> weights; //Ideally should add up to 1
	
	public MultiType(List<Type> t, List<Double> w) {
		if (t.size() != w.size()) {
			throw new IllegalArgumentException("Types and weights must be same length");
		}
		types = t;
		weights = w;
	}
	
	public boolean equals(Object t) {
		if (!(t instanceof MultiType)) return false;
		MultiType mt = (MultiType) t;
		return types.equals(mt.types) && weights.equals(mt.weights);
	}
	
	public boolean sameTypes(MultiType t) {
		return types.equals(t.types);
	}
	
}
