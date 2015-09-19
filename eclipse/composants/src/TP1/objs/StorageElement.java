package TP1.objs;

import TP1.pattern.Visitor;

/**
 * Classe correspondant à tous les éléments de stockage mémoire
 * @author doelia
 *
 */
public abstract class StorageElement
{
	public String name; // Nom
	public int basicSize; // Espace de base qu'il occupe en memoire
	public Directory parent; // Dossier parent

	/**
	 *
	 * @param nom
	 * @param t taille de l'élément, par convention 4 pour un dossier
	 */
	public StorageElement(String nom, int t) {
		name = nom;
		basicSize = t;
		parent = null;
	}

	public StorageElement(String nom, int t, Directory d) {
		this(nom, t);
		parent = d;
	}

	/**
	 * 
	 * @return la taille de l'élement
	 * Le nom d'un element racine est appelé par convention "racine"
	 */
	public abstract int getSize();
	
	public abstract void accept(Visitor v);

	public String getAbsoluteLocation() {
		return (parent != null) ?
				parent.getAbsoluteLocation() + "/" + name : 
				name;
	}

	public void setParent(Directory d) {
		parent = d;
	}

	/**
	 * Retourne la taille en octets (bytes)
	 * @return
	 */
	public int bitSize() {
		return this.getSize() * 8;
	}
	
}
