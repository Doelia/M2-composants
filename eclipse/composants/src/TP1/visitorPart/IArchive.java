package TP1.visitorPart;

import java.util.Collection;
import java.util.HashMap;

import TP1.objs.StorageElement;

public interface IArchive {
	
	public boolean add(StorageElement e);
	public HashMap getContent();
	public void extract();
	public Collection findR(String name);
}

