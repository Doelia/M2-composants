package TP1;

import java.util.ArrayList;
import java.util.Collection;

import pattern.Visitor;

// classe reprsentant un dossier
public class Directory extends ElementStockage {
	Collection<ElementStockage> listeDossier; // collection des lments de
												// stockage que le dossier
												// contient

	public Directory(String nom) {
		super(nom, 4);
		listeDossier = new ArrayList<ElementStockage>();
	}

	// ici, la taille d'un dossier est gale la somme des tailles des diffrents
	// lments prsents dans ce dossier.
	public int size() {
		int somme = basicSize;
		for (ElementStockage s : listeDossier) {
			somme = somme + s.size();
		}
		return somme;
	}

	public void ls() {
		for (ElementStockage s : listeDossier) {
			System.out.println(s.name);
		}
	}

	public int nbElm() {
		return listeDossier.size();
	}

	// ajoute l'lment e dans le dossier
	public boolean add(ElementStockage e) {
		e.nouveauParent(this); // le rpertoire courant devient le pre de l'lment
		return listeDossier.add(e); // ajout de l'lment e la collection
	}

	// supprime et retourne vrai si la suppression de l'lment e s'est bien
	// passe, faux sinon (e non prsent ou erreur)
	public boolean remove(ElementStockage e) {
		for (ElementStockage s : listeDossier) {
			if (s.name == e.name)
				return listeDossier.remove(s); // suppression de l'lment e dans la collection
		}
		return false;
	}

	public boolean include(ElementStockage e) {
		return listeDossier.contains(e);
	}

	// rend l'element de nom "nom" si il existe (sinon retourne null)
	public ElementStockage findElement(String nom) {
		for (ElementStockage s : listeDossier) {
			if (s.name.equals(nom))
				return s;
		}
		return null;
	}

	// rend la collection des adresses absolues de nom "nom" que le repertoire contient
	public ArrayList<String> find(String nom) {
		ArrayList<String> collection = new ArrayList<String>();
		for (ElementStockage s : listeDossier) {
			if (s.name.equals(nom))
				collection.add(s.absoluteAdress());
		}
		return collection;
	}

	// rend la collection des adresses absolues de nom "nom" que le rpertoire
	// contient directement ou par transitivit
	public ArrayList<String> findR(String nom) {
		
		ArrayList<String> collection = new ArrayList<String>();
		ArrayList<String> temporaire; 

		for (ElementStockage s : listeDossier) {
			if (s.name == nom)
				collection.add(s.absoluteAdress());

			if (s instanceof Directory) {
				temporaire = ((Directory) s).findR(nom);
				for (String es : temporaire) {
					collection.add(es);
				}
			}
		}

		return collection;
	}

	// affiche le contenu de la collection liste
	public void afficheCollection(ArrayList<String> liste) {
		for (String s : liste) {
			System.out.println(s);
		}
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
