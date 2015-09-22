package TP1.clientPart;

import TP1.privatePart.Archive;
import TP1.privatePart.Directory;
import TP1.privatePart.File;
import TP1.privatePart.Link;
import TP1.privatePart.StorageElement;
import TP1.privatePart.Symlink;
import TP1.privatePart.Visitor;

public class VisitorRaz implements Visitor  {
	
	public VisitorRaz(Directory dir) {
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
		for (StorageElement d : o.listeDossier) {
			if (d instanceof Directory) {
				this.visiteDirectory((Directory) d);
			}
			if (d instanceof File) {
				((File) d).setContents("");
			}
		}
	}

	@Override
	public void visiteArchive(Archive o) {
	}

}
