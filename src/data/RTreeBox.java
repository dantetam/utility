package data;

import java.util.ArrayList;
import java.util.List;

public class RTreeBox<T extends Point> extends Box {

	public static int CAPACITY = 5;
	public List<RTreeBox> children;
	public List<T> data;
	
	public RTreeBox() {
		children = new ArrayList<RTreeBox>();
		data = new ArrayList<T>();
	}
	
}
