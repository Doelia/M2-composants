package TP1.clientPart;

import TP1.privatePart.Archive;
import TP1.privatePart.Directory;
import TP1.privatePart.File;
import TP1.privatePart.Link;
import TP1.privatePart.StorageElement;
import TP1.privatePart.Visitor;

public class VisitorCounter implements Visitor {
	
	private int num = 0;
	
	/**
	 * Retourne le nombre de fichiers dépassants 10 dans un repertoire
	 * @return
	 */
	public int getNumberBigFiles(Directory dir) {
		this.num = 0;
		dir.accept(this);
		return num;
	}
	
	@Override
	public void visiteLink(Link o) {
	}

	@Override
	public void visiteFile(File o) {
	}

	@Override
	public void visiteDirectory(Directory o) {
		for (StorageElement d : o.listeDossier) {
			if (d instanceof Directory) {
				this.visiteDirectory((Directory) d);
			}
			if (d instanceof File) {
				if (d.getSize() >= 10) {
					this.num++;
				}
			}
		}
	}

	@Override
	public void visiteArchive(Archive o) {
	}

}
