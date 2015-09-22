package TP1.clientPart;

import TP1.privatePart.Archive;
import TP1.privatePart.Directory;
import TP1.privatePart.File;
import TP1.privatePart.Link;
import TP1.privatePart.Symlink;
import TP1.privatePart.Visitor;

/**
 * @author Stéphane Wouters
 */

public class JavaCleanVisitor implements Visitor  {
	
	public JavaCleanVisitor(Directory dir) {
		dir.accept(this);
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
	}

	@Override
	public void visiteArchive(Archive o) {
	}

}
