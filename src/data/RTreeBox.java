package data;

import java.util.ArrayList;
import java.util.List;

public class RTreeBox<T extends Point> extends Box {

	public static int MAX_CAPACITY = 4;
	public List<RTreeBox> children;
	public List<T> data;
	
	public RTreeBox() {
		children = new ArrayList<RTreeBox>();
		data = new ArrayList<T>();
	}
	
}
