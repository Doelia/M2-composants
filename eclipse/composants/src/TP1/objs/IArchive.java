package TP1.objs;

import java.util.Collection;
import java.util.HashMap;

public interface IArchive {
	
	public boolean add(ElementStockage e);
	public HashMap getContent();
	public void extract();
	public Collection findR(String name);
}

