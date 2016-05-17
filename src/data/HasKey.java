package data;

public interface HasKey<K extends TwoWayComparator<K>> {

	public K key();
	
}
