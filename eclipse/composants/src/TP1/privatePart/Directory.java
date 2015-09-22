package TP1.privatePart;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Stéphane Wouters
 */

public class Directory extends StorageElement {
	
	public Collection<StorageElement> listeDossier; // Contenu

	public Directory(String nom) {
		super(nom, 4);
		listeDossier = new ArrayList<StorageElement>();
	}

	/**
	 * Retourne la taille totale du repertoire (somme récursive des fils)
	 */
	public int getSize() {
		int somme = basicSize;
		for (StorageElement s : listeDossier) {
			somme = somme + s.getSize();
		}
		return somme;
	}

	public void ls() {
		for (StorageElement s : listeDossier) {
			System.out.println(s.name);
		}
	}

	public int nbElm() {
		return listeDossier.size();
	}

	// ajoute l'lment e dans le dossier
	public boolean add(StorageElement e) {
		e.setParent(this); // le rpertoire courant devient le pre de l'lment
		return listeDossier.add(e); // ajout de l'lment e la collection
	}

	// supprime et retourne vrai si la suppression de l'lment e s'est bien
	// passe, faux sinon (e non prsent ou erreur)
	public boolean remove(StorageElement e) {
		for (StorageElement s : listeDossier) {
			if (s.name == e.name)
				return listeDossier.remove(s); // suppression de l'lment e dans la collection
		}
		return false;
	}

	public boolean include(StorageElement e) {
		return listeDossier.contains(e);
	}

	/**
	 * rend l'element de nom "nom" si il existe, null sinon
	 * @param nom
	 */
	public StorageElement findElement(String nom) {
		for (StorageElement s : listeDossier) {
			if (s.name.equals(nom))
				return s;
		}
		return null;
	}

	/**
	 * Retourne la collection des adresses absolues de nom "nom" que le repertoire contient
	 * @param nom
	 */
	public ArrayList<String> find(String nom) {
		ArrayList<String> collection = new ArrayList<String>();
		for (StorageElement s : listeDossier) {
			if (s.name.equals(nom))
				collection.add(s.getAbsoluteLocation());
		}
		return collection;
	}

	/**
	 * Retoune la liste des adresses absolues de nom "nom" que le repertoire contient
	 * par transitivité
	 * @param nom
	 * @return
	 */
	public ArrayList<String> findR(String nom) {
		
		ArrayList<String> collection = new ArrayList<String>();
		ArrayList<String> temporaire; 

		for (StorageElement s : listeDossier) {
			if (s.name == nom)
				collection.add(s.getAbsoluteLocation());

			if (s instanceof Directory) {
				temporaire = ((Directory) s).findR(nom);
				for (String es : temporaire) {
					collection.add(es);
				}
			}
		}

		return collection;
	}

	public void afficheCollection(ArrayList<String> liste) {
		for (String s : liste) {
			System.out.println(s);
		}
	}

	@Override
	public void accept(Visitor v) {
		v.visiteDirectory(this);
	}

}
