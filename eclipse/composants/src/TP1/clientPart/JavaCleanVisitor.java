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
 * 
 * Visiter un répertoire et ses sous-répertoires pour y détruire tous les fichiers dont le nom est suffixé par ”.class”.
 * Cet exercice pose le problème intéressant du parcours modificateur d’une collection.
 */

public class JavaCleanVisitor implements Visitor  {
	
	private ArrayList<File> toRemove;
	
	public void postProcess() {
		for (File f : this.toRemove) {
			f.remove();
		}
	}
	
	public JavaCleanVisitor(Directory dir) {
		dir.accept(this);
	}

	@Override
	public void visiteLink(Link o) {
	}

	@Override
	public void visiteFile(File o) {
		if (o.name.endsWith(".class")) {
			this.toRemove.add(o);
		}
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
