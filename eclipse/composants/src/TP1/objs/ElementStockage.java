package TP1.objs;

import TP1.pattern.Visitor;

public abstract class ElementStockage
// classe abstraite correspondant tous lment de stockage mmoire.
{
	public String name; // un nom
	public int basicSize; // espace de base qu'il occupe en memoire
	public Directory parent; // dossier parent

	public ElementStockage(String nom, int t) {
		name = nom;
		basicSize = t;
		parent = null;
	}

	public ElementStockage(String nom, int t, Directory d) {
		name = nom;
		basicSize = t;
		parent = d;
	}

	public abstract int size(); // classe abstraite car spcifique diffrentes
								// paramtrisations (retourne la taille de
								// l'lment de stockage)

	// retourne l'adresse absolue de l'lment.
	public String absoluteAdress() {
		if (parent != null) // s'il a un parent
			return parent.absoluteAdress() + "/" + name;
		else
			return name; // ici on est la racine, on suppose que son nom est
							// racine
	}

	public void nouveauParent(Directory d) {
		parent = d;
	}

	public int bitSize() {
		return this.size() * 8;
	}

	public abstract void accept(Visitor v);
}
