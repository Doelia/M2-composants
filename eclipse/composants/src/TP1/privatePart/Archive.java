package TP1.privatePart;

import java.util.HashMap;

import TP1.clientPart.IArchive;

/**
 * Classe représentant une archive
 * Hérite de Directory car elle possède toutes les caractéristiques d'un dossier
 * Dont la manipulation de collection
 * @author doelia
 *
 */
public class Archive extends Directory implements IArchive {
	
	public Archive(String nom) {
		super(nom);
	}

	public HashMap<String, StorageElement> getContent() {
		HashMap<String, StorageElement> map = new HashMap<String, StorageElement>();
		for (StorageElement s : listeDossier) {
			map.put(s.getAbsoluteLocation(), s);
		}
		return map;
	}

	public void extract() {
		for (StorageElement s : listeDossier) {
			s.parent.add(s);
		}
	}
	
	@Override
	public void accept(Visitor v) {
		v.visiteArchive(this);
	}

}
