package TP1.objs;

import java.util.HashMap;

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

	public HashMap<String, ElementStockage> getContent() {
		HashMap<String, ElementStockage> map = new HashMap<String, ElementStockage>();
		for (ElementStockage s : listeDossier) {
			map.put(s.getAbsoluteLocation(), s);
		}
		return map;
	}

	public void extract() {
		for (ElementStockage s : listeDossier) {
			s.parent.add(s);
		}
	}

}
