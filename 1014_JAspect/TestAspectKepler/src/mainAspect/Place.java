package mainAspect;

import java.util.ArrayList;
import java.util.List;

public class Place {

	String name;
	List<Personne> l = new ArrayList<Personne>();
	
	public Place(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String s = "Place "+name+": ";
		for (Personne p : l) {
			s += p + ", ";
		}
		return s;
	}
	
	
	public void add(Personne p) {
		l.add(p);
	}
	
}
