package TP1.clientPart;

import TP1.privatePart.Archive;
import TP1.privatePart.Directory;
import TP1.privatePart.File;
import TP1.privatePart.Link;
import TP1.privatePart.StorageElement;
import TP1.privatePart.Symlink;
import TP1.privatePart.Visitor;

/**
 * @author Stéphane Wouters
 */

public class VisitorCounter implements Visitor {
	
	ArrayList<File>
	
	private int bigFiles = 0; // Nombre de fichiers ayants une taille >= 10
	
	/**
	 * Retourne le nombre de fichiers dépassants 10 dans un repertoire
	 * @return
	 */
	public int getNumberBigFiles(Directory dir) {
		this.bigFiles = 0;
		dir.accept(this);
		return bigFiles;
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
					this.bigFiles++;
				}
			}
		}
	}

	@Override
	public void visiteArchive(Archive o) {
	}

	@Override
	public void visiteSymLink(Symlink o) {
	}

}
