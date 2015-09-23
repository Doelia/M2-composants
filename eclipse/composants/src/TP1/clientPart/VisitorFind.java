package TP1.clientPart;

import java.util.ArrayList;

import TP1.privatePart.Archive;
import TP1.privatePart.Directory;
import TP1.privatePart.File;
import TP1.privatePart.Link;
import TP1.privatePart.Symlink;
import TP1.privatePart.Visitor;

/**
 * @author Stéphane Wouters
 */

public class VisitorFind  implements Visitor  {
	
	private String name;
	private ArrayList<String> list;
	
	public VisitorFind(String name) {
		this.name = name;
		list = new ArrayList<String>();
	}

	public ArrayList<String> getResult() {
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
		list.addAll(o.findR(name));
	}

	@Override
	public void visiteArchive(Archive o) {
	}

}
