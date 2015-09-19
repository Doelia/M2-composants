package TP1.privatePart;

/**
 * Classe correspondant à tous les éléments de stockage mémoire
 * @author doelia
 *
 */
public abstract class StorageElement
{
	public String name; // Nom
	public int basicSize; // Espace de base qu'il occupe en memoire
	public Directory parent; // Dossier parent, Le nom d'un element racine est appelé par convention "racine"

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

	public abstract int getSize();

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
	
	public abstract void accept(Visitor v);
	
}
