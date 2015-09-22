package TP1.clientPart;

import java.util.ArrayList;

import TP1.privatePart.Archive;
import TP1.privatePart.Directory;
import TP1.privatePart.File;
import TP1.privatePart.Link;
import TP1.privatePart.Symlink;
import TP1.privatePart.Visitor;

public class VisitorFind  implements Visitor  {
	
	private String name;
	private ArrayList<String> list;

	public ArrayList<String> find(String name, Directory dir) {
		this.name = name;
		dir.accept(this);
		return list;
	}
	
	@Override
	public void visiteLink(Link o) {
	}

	@Override
	public void visiteFile(File o) {
	}

	@Override
	public void visiteSymLink(Symlink o) {
	}

	@Override
	public void visiteDirectory(Directory o) {
		list = o.findR(name);
	}

	@Override
	public void visiteArchive(Archive o) {
	}

}
