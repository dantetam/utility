package data;

import java.awt.Color;

public class Type {

	public String typeField;
	public Color colorRep;
	
	public Type(String t, Color c) {
		typeField = t;
		colorRep = c;
	}
	
	public boolean equals(Object other) {
		if (!(other instanceof Type)) return false;
		return hashCode() == other.hashCode();
	}
	
	public int hashCode() {
		return typeField.hashCode() + colorRep.hashCode();
	}
	
}
