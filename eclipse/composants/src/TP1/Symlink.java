package TP1;

import pattern.Visitor;

public class Symlink extends ElementStockage {
	
	private ElementStockage reference;

	public Symlink(String nom) {
		super(nom, 0);
		reference = null;
	}

	public Symlink(String nom, ElementStockage e) {
		super(nom, 0);
		reference = e;
	}

	public int size() {
		return (reference == null) ? 0 :  reference.size();
	}

	// affiche le symbole du lien puis l'adresse absoule de sa rfrence
	public void cat() {
		System.out.println("ln -s " + reference.absoluteAdress() + " " + name);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
	}

}
