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
	
	public static Type randomType() {
		Color c = new Color(
				(float)Math.random(),
				(float)Math.random(),
				(float)Math.random()
				);
		String str = "";
		for (int i = 0; i < ((int)(Math.random()*15)); i++) {
			str += (char) 97 + ((int)(Math.random()*26));
		}
		return new Type(str, c);
	}
	
}
